package itemTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itemSrc.*;


public class QueueOfCustsTest {
	
	QueueOfCusts qOfCusts;

	@Test
	public void testQueueOfCusts() {
		 qOfCusts = new QueueOfCusts();
		 assertTrue(qOfCusts.getNumQueueing()==0);
	}

	@Test
	public void testAddDetails() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		assertSame(qOfCusts.get(0),cinqueue);
	
	}

	@Test
	public void testGetNumberOfEntries() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		assertTrue(qOfCusts.getNumberOfEntries()==1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "p335",3);
		qOfCusts.addDetails(cinqueue2);
		assertTrue(qOfCusts.getNumberOfEntries()==2);
	}

	@Test
	public void testGetNumQueueing() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing()==1);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "p335",3);
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.getNumQueueing()==2);
		
	}

	@Test
	public void testGet() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertSame(qOfCusts.get(0),cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "p335",3);
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.get(1),cinqueue2);
		
	}

	@Test
	public void testGetNext() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertSame(qOfCusts.getNext(), cinqueue);
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "p335",3);
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.getNext(),cinqueue2);
	}

	@Test
	public void testGetQueueString() {
		qOfCusts = new QueueOfCusts(); 
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.getQueueString(),cinqueue.toString()+"\n");
		CustInQueue cinqueue2 = new CustInQueue("Jenny", "p335",3);
		qOfCusts.addDetails(cinqueue2);
		qOfCusts.addToQueue();
		assertEquals(qOfCusts.getQueueString(),cinqueue.toString()+"\n"+cinqueue2.toString()+"\n");
	}

	@Test
	public void testAddToQueue() {
		qOfCusts = new QueueOfCusts();
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		qOfCusts.addDetails(cinqueue);
		assertTrue(qOfCusts.get(0).isInQueue() == false);
		qOfCusts.addToQueue();
		assertTrue(qOfCusts.get(0).isInQueue() == true);
	}

}
