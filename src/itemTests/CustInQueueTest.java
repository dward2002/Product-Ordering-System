package itemTests;

import static org.junit.Assert.*;
import org.junit.Test;

import itemSrc.*;

public class CustInQueueTest {

	@Test
	public void testCustInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		CustInQueue cinqueue1 = new CustInQueue("Andrew", "pppp",3);
		CustInQueue cinqueue2 = new CustInQueue("Andrew", "1111",3);
		CustInQueue cinqueue3 = new CustInQueue("Andrew", "p1111111",3);
		assertSame(cinqueue.getName(),"Andrew");
		assertEquals(cinqueue.getpId(),"p134");
		assertEquals(cinqueue1.getpId(),null);
		assertEquals(cinqueue2.getpId(),null);
		assertEquals(cinqueue3.getpId(),null);
	}

	@Test
	public void testGetName() {
		
	}

	@Test
	public void testSetName() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		cinqueue.setName("Meg");
		assertSame(cinqueue.getName(),"Meg");
		assertEquals(cinqueue.getpId(),"p134");
		
	}

	@Test
	public void testGetpId() {
		
	}

	@Test
	public void testSetpId() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p135",3);
	    cinqueue.setpId("p135");
		assertEquals(cinqueue.getpId(),"p135");
	}

	@Test
	public void testGetqNum() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p135",3);
		cinqueue.setqNum(10);
		assertTrue(cinqueue.getqNum() == 10);
	}

	@Test
	public void testSetqNum() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		cinqueue.setqNum(1);
		assertTrue(cinqueue.getqNum()==1);
		
	}

	@Test
	public void testIsInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		assertFalse(cinqueue.isInQueue()!=false);
	}

	@Test
	public void testSetInQueue() {
		CustInQueue cinqueue = new CustInQueue("Andrew", "p134",3);
		cinqueue.setInQueue(true);
		assertFalse(cinqueue.isInQueue()==false);
	}

}
