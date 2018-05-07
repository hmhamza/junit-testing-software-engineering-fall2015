package Part2;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals(10000,SEK100.getAmount(),0.00001);
		assertEquals(1000,EUR10.getAmount(),0.00001);
		assertEquals(20000,SEK200.getAmount(),0.00001);
		assertEquals(2000,EUR20.getAmount(),0.00001);
		assertEquals(0,SEK0.getAmount(),0.00001);
		assertEquals(0,EUR0.getAmount(),0.00001);
		assertEquals(-10000,SEKn100.getAmount(),0.00001);
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SEK100.getCurrency());
		assertEquals(EUR,EUR10.getCurrency());
		assertEquals(SEK,SEK200.getCurrency());
		assertEquals(EUR,EUR20.getCurrency());
		assertEquals(SEK,SEK0.getCurrency());
		assertEquals(EUR,EUR0.getCurrency());
		assertEquals(SEK,SEKn100.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("100.0 SEK",SEK100.toString());
		assertEquals("10.0 EUR",EUR10.toString());
		assertEquals("200.0 SEK",SEK200.toString());
		assertEquals("20.0 EUR",EUR20.toString());
		assertEquals("0.0 SEK",SEK0.toString());
		assertEquals("0.0 EUR",EUR0.toString());
		assertEquals("-100.0 SEK",SEKn100.toString());
		
		Money s = new Money(5689, SEK);
		assertEquals("56.89 SEK",s.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals(1500,SEK100.universalValue(),0.00001);
		assertEquals(1500,EUR10.universalValue(),0.00001);
		assertEquals(3000,SEK200.universalValue(),0.00001);
		assertEquals(3000,EUR20.universalValue(),0.00001);
		assertEquals(0,SEK0.universalValue(),0.00001);
		assertEquals(0,EUR0.universalValue(),0.00001);
		assertEquals(-1500,SEKn100.universalValue(),0.00001);
	}

	@Test
	public void testEqualsMoney() {
		assertTrue("Value of SEK100 is equal to that of EUR10", SEK100.equals(EUR10));
		assertTrue("Value of SEK200 is equal to that of EUR20", SEK200.equals(EUR20));
		assertTrue("Value of SEK0 is equal to that of EUR0", SEK0.equals(EUR0));
		
		assertFalse("Value of SEKn100 is equal to that of EUR0", SEKn100.equals(SEK100));
	}

	@Test
	public void testAdd() {
		assertEquals(30000,SEK100.add(EUR20).getAmount(),0.00001);
		assertEquals(1000,EUR10.add(SEK0).getAmount(),0.00001);
		assertEquals(10000,SEK200.add(SEKn100).getAmount(),0.00001);
	}

	@Test
	public void testSub() {
		assertEquals(1000,EUR20.sub(SEK100).getAmount(),0.00001);
		assertEquals(0,SEK100.sub(EUR10).getAmount(),0.00001);
		assertEquals(-30000,SEKn100.sub(SEK200).getAmount(),0.00001);
	}

	@Test
	public void testIsZero() {
		assertFalse("SEK100 in Non-Zero", SEK100.isZero());
		assertFalse("EUR10 in Non-Zero", EUR10.isZero());
		assertFalse("SEK200 in Non-Zero", SEK200.isZero());
		assertFalse("EUR20 in Non-Zero", EUR20.isZero());
		assertTrue("SEK0 in Zero", SEK0.isZero());
		assertTrue("EUR0 in Zero", EUR0.isZero());
		assertFalse("SEKn100 in Non-Zero", SEKn100.isZero());
	}

	@Test
	public void testNegate() {
		assertTrue("",-1*SEK100.getAmount()==SEK100.negate().getAmount());
		assertTrue("",-1*EUR10.getAmount()==EUR10.negate().getAmount());
		assertTrue("",-1*SEK200.getAmount()==SEK200.negate().getAmount());
		assertTrue("",-1*EUR20.getAmount()==EUR20.negate().getAmount());
		assertTrue("",-1*SEK0.getAmount()==SEK0.negate().getAmount());
		assertTrue("",-1*EUR0.getAmount()==EUR0.negate().getAmount());
		assertTrue("",-1*SEK100.getAmount()==SEK100.negate().getAmount());
		assertTrue("",-1*SEKn100.getAmount()==SEKn100.negate().getAmount());
		
		
		
	}

	@Test
	public void testCompareTo() {
		assertEquals(0,SEK100.compareTo(EUR10));
		assertEquals(0,SEK200.compareTo(EUR20));
		assertEquals(0,SEK0.compareTo(EUR0));
		
		assertEquals(-1,SEKn100.compareTo(SEK0));
		assertEquals(-1,SEKn100.compareTo(EUR0));
		
		assertEquals(-1,SEK100.compareTo(EUR20));
	}
}
