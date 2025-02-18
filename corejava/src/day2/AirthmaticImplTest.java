package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AirthmaticImplTest {
	
	private Airthmatic ari=new AirthmaticImpl();

	@Test
	void testAdd() {
		assertEquals(2, ari.add(4.0,2.0));
		
	}
	@Test
	void testSub() {
		assertEquals(2, ari.sub(4.0,2.0));
		
	}
	@Test
	void testMul() {
		assertEquals(2, ari.mul(4.0,2.0));
		
	}
	@Test
	void testDivWithDouble() {
		assertEquals(1.666, ari.div(5.,3),0.001);
		assertEquals(Double.POSITIVE_INFINITY, ari.div(5.0, 0),0.0001);
	}
	@Test
	void testDivWithInt() {
		assertEquals(2, ari.div(4,2));
		assertEquals(3, ari.div(7,2));
	}
	@Test
    void testDivWithIntDenomIsZero() {
		try {
		ari.div(3,0);
		fail("exception is expected..");
		}catch(Exception e) {
			
		}
	}

}
