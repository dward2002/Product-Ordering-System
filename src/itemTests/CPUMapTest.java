package itemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;


public class CPUMapTest {

	CPUMap cpuList;
	
	@Test
	public void testCPUMap() {
		cpuList = new CPUMap();
		assertFalse(cpuList.hasParcel()==true);
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		cpuList.addDetails(p);
		assertTrue(cpuList.getNumberOfEntries()==2);
		assertEquals(cpuList.findParcel("X222"),p2);
	}

	@Test
	public void testAddDetails() {
		cpuList = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		
		assertTrue(cpuList.getNumberOfEntries()==1);
		cpuList.addDetails(p);
		assertEquals(cpuList.findParcel("X164"),p);
		assertTrue(cpuList.getNumberOfEntries()==2);
	}

	@Test
	public void testHasCPU() {
		cpuList = new CPUMap();
		assertTrue(cpuList.hasParcel()==false);
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		assertFalse(cpuList.hasParcel()==false);
		cpuList.addDetails(p);
		assertTrue(cpuList.getNumberOfEntries()==2);
	}

	@Test
	public void testGetNumberOfEntries() {
		cpuList = new CPUMap();
		assertTrue(cpuList.getNumberOfEntries()==0);
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		assertTrue(cpuList.getNumberOfEntries()>0);
		cpuList.addDetails(p);
		assertTrue(cpuList.getNumberOfEntries()==2);
	}

	@Test
	public void testAllGone() {
		cpuList = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		
		cpuList.setCollected(p2);
		
		assertTrue(cpuList.allGone()==true);
		cpuList.addDetails(p);
		assertFalse(cpuList.allGone()==true);
		
	}

	@Test
	public void testListDetails() {
		cpuList = new CPUMap();
		//CPU p = new CPU("lt64s", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		String details [] = cpuList.listDetails().split(",");
		assertTrue(details.length==6);
	}

	@Test
	public void testSetCollected() {
		cpuList = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		cpuList.addDetails(p);
		cpuList.setCollected(p2);
		assertTrue(cpuList.hasParcel()==true);
		cpuList.setCollected(p);
		assertTrue(cpuList.allGone()==true);
	}

	@Test
	public void testListUncollected() {
		cpuList = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		cpuList.addDetails(p);
		cpuList.setCollected(p2);
		cpuList.listUncollected();
		assertTrue(cpuList.findParcel("X222").isCollected()==true);
		
	}

	@Test
	public void testFindCPU() {
		cpuList = new CPUMap();
		CPU p = new CPU("X164", 2, 5, 4, 3,1);
		CPU p2 = new CPU("X222", 1, 3, 2, 3,1);
		cpuList.addDetails(p2);
		cpuList.addDetails(p);
		
		assertNotEquals(cpuList.findParcel("X222"), p);
		assertEquals(cpuList.findParcel("X222"), p2);
	}

}
