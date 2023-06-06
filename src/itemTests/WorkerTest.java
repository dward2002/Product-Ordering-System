package itemTests;

import static org.junit.Assert.*;

import org.junit.*;

import itemSrc.*;


public class WorkerTest {

	Worker wareHouseWorker;

	@Test
	public void testWorker() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "X164",3);
		CustInQueue cin2 = new CustInQueue("Janice", "X222",3);
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		CPUMap allCPUs = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		allCPUs.addDetails(p);
		allCPUs.addDetails(p2);
		wareHouseWorker = new Worker( qOfCusts, allCPUs, 5, 4);
		
		assertTrue(wareHouseWorker.getNum()==4);
		assertEquals(wareHouseWorker.getNext().getName(), "Andrew");
		wareHouseWorker.setClosed();
		assertEquals(wareHouseWorker.getNext().getName(), "Janice");
	}

	@Test
	public void testGetCurrentCust() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "X222",3);
		CustInQueue cin2 = new CustInQueue("Janice", "X164",3);
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		CPUMap allCPUs = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		allCPUs.addDetails(p);
		allCPUs.addDetails(p2);
		
		wareHouseWorker = new Worker( qOfCusts, allCPUs, 5, 4);
		assertEquals(qOfCusts.getNext(),cin);
		wareHouseWorker.setClosed();
		assertEquals(qOfCusts.getNext(),cin2);
	}

	@Test
	public void testGetNum() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "X222",3);
		CustInQueue cin2 = new CustInQueue("Janice", "X164",3);
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		CPUMap allCPUs = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		allCPUs.addDetails(p);
		allCPUs.addDetails(p2);
		
		wareHouseWorker = new Worker( qOfCusts, allCPUs, 5, 4);
		assertEquals(wareHouseWorker.getNum(),4);
	}

	@Test
	public void testGetClosed() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		
		CustInQueue cin = new CustInQueue("Andrew", "X222",3);
		CustInQueue cin2 = new CustInQueue("Janice", "X164",3);
		
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		qOfCusts.addDetails(cin2);
		qOfCusts.addToQueue();
		
		CPUMap allCPUs = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		allCPUs.addDetails(p);
		allCPUs.addDetails(p2);
		
		wareHouseWorker = new Worker( qOfCusts, allCPUs, 5, 4);
		assertEquals(qOfCusts.getNext(),cin);
		wareHouseWorker.setClosed();
		wareHouseWorker.getClosed();
		assertFalse(wareHouseWorker.getCurrentCust()==cin);
		assertFalse(wareHouseWorker.getCurrentCust()==cin2);
	}

	@Test
	public void testSetClosed() {
	}

	@Test
	public void testProcessOneCustomer() {
		QueueOfCusts qOfCusts = new QueueOfCusts();
		assertTrue(qOfCusts.getNumQueueing()==0);
		CustInQueue cin = new CustInQueue("Andrew", "X222",3);
		qOfCusts.addDetails(cin);
		qOfCusts.addToQueue();
		CustInQueue cin1 = new CustInQueue("Andrew", "X222",3);
		qOfCusts.addDetails(cin1);
		CPUMap allCPUs = new CPUMap();
		CPU p = new CPU("X222", 2, 5, 4, 3,1);
		allCPUs.addDetails(p);
		wareHouseWorker = new Worker( qOfCusts, allCPUs, 5, 4);
		assertTrue(wareHouseWorker.getFinished() == false);
		wareHouseWorker.processOneCustomer();
		assertTrue(wareHouseWorker.getFinished() == true);
		wareHouseWorker.processOneCustomer();
		assertTrue(wareHouseWorker.getFinished() == true);
	}

}
