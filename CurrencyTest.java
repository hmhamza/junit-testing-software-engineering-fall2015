package Part2;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		
		assertEquals( "SEK", SEK.getName());
		assertEquals( "DKK", DKK.getName());
		assertEquals( "EUR", EUR.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals(0.15,SEK.getRate(),0.00001);
		assertEquals(0.20,DKK.getRate(),0.00001);
		assertEquals(1.5,EUR.getRate(),0.00001);
	}
	
	@Test
	public void testSetRate() {
		Currency c = new Currency("DUMMY",0.0);
		c.setRate(0.24);
		assertTrue("Rate should be 0.24", c.getRate()==0.24);
	}
	
	@Test
	public void testuniversalValue() {
		
		assertEquals(185175,SEK.universalValue(12345),0.00001);
		assertEquals(135780,DKK.universalValue(6789),0.00001);
		assertEquals(21708000,EUR.universalValue(144720),0.00001);
		
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals(164533,SEK.valueInThisCurrency(1234, DKK),0.00001);
		assertEquals(422250,DKK.valueInThisCurrency(563, EUR),0.00001);
		assertEquals(90120,EUR.valueInThisCurrency(9012, SEK),0.00001);
	}

}
