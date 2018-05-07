package Part2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("SweBank",SweBank.getName());
		assertEquals("Nordea",Nordea.getName());
		assertEquals("DanskeBank",DanskeBank.getName());
	
	}

	@Test
	public void testGetCurrency() {
		assertEquals(SEK,SweBank.getCurrency());
		assertEquals(SEK,Nordea.getCurrency());
		assertEquals(DKK,DanskeBank.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		//SweBank.openAccount("Ulrika");
		//Nordea.openAccount("Bob");
		
		Nordea.openAccount("Hamza");
		//Nordea.openAccount("Hamza");
		
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		
		//Nordea.deposit("Hamza", new Money(2000,SEK));
		
		DanskeBank.deposit("Gertrud", new Money(1000,DKK));
		assertEquals(1000,DanskeBank.getBalance("Gertrud"),0.00001);
		
		Nordea.deposit("Bob", new Money(5000,SEK));
		assertEquals(5000,Nordea.getBalance("Bob"),0.00001);
		
		SweBank.deposit("Bob", new Money(2000,DKK));
		assertEquals(2667,SweBank.getBalance("Bob"),0.00001);
	
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		//Nordea.deposit("Hamza", new Money(2000,SEK));
		
		DanskeBank.withdraw("Gertrud", new Money(1000,DKK));
		assertEquals(-1000,DanskeBank.getBalance("Gertrud"),0.00001);
		
		Nordea.deposit("Bob", new Money(5000,SEK));
		Nordea.withdraw("Bob", new Money(2300,SEK));
		assertEquals(2700,Nordea.getBalance("Bob"),0.00001);
		
		SweBank.deposit("Bob", new Money(8000,SEK));
		SweBank.withdraw("Bob", new Money(6500,DKK));
		assertEquals(-667,SweBank.getBalance("Bob"),0.00001);
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals(0,SweBank.getBalance("Ulrika"),0.00001);
		assertEquals(0,SweBank.getBalance("Bob"),0.00001);
		assertEquals(0,SweBank.getBalance("Bob"),0.00001);
		assertEquals(0,DanskeBank.getBalance("Gertrud"),0.00001);
		
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		
		DanskeBank.deposit("Gertrud", new Money(7000,DKK));
		DanskeBank.transfer("Gertrud",SweBank, "Ulrika", new Money(3000,DKK));
		assertEquals(4000,SweBank.getBalance("Ulrika"),0.00001);
		
		SweBank.transfer("Ulrika",Nordea, "Bob", new Money(2000,SEK));
		assertEquals(2000,Nordea.getBalance("Bob"),0.00001);
		
		SweBank.transfer("Bob","Ulrika", new Money(1500,SEK));
		assertEquals(3500,SweBank.getBalance("Ulrika"),0.00001);
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		
		SweBank.deposit("Bob", new Money(200,SEK));
		SweBank.addTimedPayment("Bob", "H1", 2, 1, new Money(20,SEK), DanskeBank, "Gertrud");
		SweBank.tick();
		SweBank.tick();
		SweBank.tick();
		
		assertEquals(180,SweBank.getBalance("Bob"),0.00001);
		assertEquals(15,DanskeBank.getBalance("Gertrud"),0.00001);
		
		SweBank.tick();
		SweBank.tick();
		
		assertEquals(160,SweBank.getBalance("Bob"),0.00001);
		assertEquals(30,DanskeBank.getBalance("Gertrud"),0.00001);
	}
}
