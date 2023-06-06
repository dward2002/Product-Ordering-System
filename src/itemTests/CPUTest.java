package itemTests;

import static org.junit.Assert.*;

import org.junit.Test;

import itemSrc.*;

public class CPUTest {

	CPU  p;
	CPU p1;
	
	
	@Test
	public void testCPU() {
		  p = new CPU("b202", 2, 3, 4, 3, 9);
		  assertEquals(p.getId(), "b202");
	}

	@Test
	public void testGetId() {
		  p = new CPU("b202", 2, 3, 4, 8, 9);
		  assertTrue(p.getId() =="b202");
	}

	@Test
	public void testSetId() {
		 p = new CPU("b022", 2, 3, 4, 8, 9);
		 assertSame(p.getId(),"b022");
		 p.setId("x111");
		 assertEquals(p.getId(),"x111");
		 
	}

	@Test
	public void testGetDays() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.getDays()!=2);
		 
	}

	@Test
	public void testSetDays() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.getDays()!=2);
		 p.setDays(1);
		 assertFalse(p.getDays()==2);
	}

	@Test
	public void testGetCores() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getCores()==3);
	}

	@Test
	public void testSetCores() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getCores()==3);
		 p.setCores(5);
		 assertFalse(p.getCores()==3);
	}

	@Test
	public void testGetClockSpeed() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getClockSpeed()==4);
		
	}

	@Test
	public void testSetClockSpeed() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getClockSpeed()==4);
		 p.setClockSpeed(7);
		 assertFalse(p.getClockSpeed()!=7);
	}

	@Test
	public void testGetQuantity() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getQuantity()==8);
	}

	@Test
	public void testSetQuantity() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.getQuantity()!=8);
		 p.setQuantity(2);
		 assertTrue(p.getQuantity()==2);
	}

	@Test
	public void testGetCache() {
		p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertTrue(p.getPrice()==9);
	}

	@Test
	public void testSetCache() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.getPrice()!=9);
		 p.setCache(11);
		 assertTrue(p.getPrice()==11);
	}

	@Test
	public void testIsCollected() {
		 p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.isCollected()!=false);
		 
	}

	@Test
	public void testSetCollected() {
		p = new CPU("X221", 2, 3, 4, 8, 9);
		 assertFalse(p.isCollected()!=false);
		 p.setCollected(true);
		 assertTrue(p.isCollected()==true);
	}
	

	@Test
	public void testOrderPrice() {
		p = new CPU("X221", 2, 3, 4, 8, 9);
		p1 = new CPU("C221", 2, 3, 4, 8, 9);
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		assertEquals(p.orderPrice(cinqueue.getQuantity()),"21.60");
		assertEquals(p1.orderPrice(cinqueue.getQuantity()),"27.00");
	}

}
