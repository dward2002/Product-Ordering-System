package itemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;


public class ManagerTest {
	
	@Test
	public void testManager() {
		Manager m = new Manager();
		m.initialiseData();
		assertEquals(m.getCustQ().getNumQueueing(),10);	
	}
	
	@Test
	public void testInitialiseData() {
		Manager m = new Manager();
		m.initialiseData();
		assertEquals(m.getCustQ().getNumQueueing(),10);	
	}
	
	@Test
	public void testInitialiseWorkers() {
		Manager m = new Manager();
		m.initialiseData();
		m.initialiseWorkers();
		assertEquals(m.findWorker(0).getNext().getpId(), "X009");
	}

	@Test
	public void testReadCustFile() {
		Manager m = new Manager();
		m.initialiseData();
		assertEquals(m.getCustQ().getNumberOfEntries(),20);	
	}

	@Test
	public void testReadParcelFile() {
		Manager m = new Manager();
		m.initialiseData();
		assertEquals(m.getAllCPUs().getNumberOfEntries(),10);
	}

}
