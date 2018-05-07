package Part2;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		SweBank.deposit("Alice", new Money(1000000, SEK));
		
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		testAccount.addTimedPayment("M1",20,100,new Money(1245, DKK),SweBank,"Alice");
		assertTrue("",testAccount.timedPaymentExists("M1"));
		
		testAccount.addTimedPayment("M2",20,100,new Money(1245, DKK),SweBank,"Alice");
		assertTrue("",testAccount.timedPaymentExists("M2"));
		
		testAccount.removeTimedPayment("M1");
		assertFalse("",testAccount.timedPaymentExists("M1"));
		
		Account t= new Account("Hamza", DKK);
		t.deposit(new Money(200, DKK));
		
		t.addTimedPayment("T1",3,2,new Money(50, DKK),SweBank,"Alice");
		assertTrue("",t.timedPaymentExists("T1"));
		
		t.removeTimedPayment("T1");
		assertFalse("",t.timedPaymentExists("T1"));
		
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		
		testAccount.addTimedPayment("P1",2,1,new Money(5000000, SEK),SweBank,"Alice");
		testAccount.tick();
		testAccount.tick();
		testAccount.tick();
		
		assertEquals(5000000,testAccount.getBalance().getAmount(),0.00001);
		
		testAccount.tick();
		testAccount.tick();
		assertEquals(0,testAccount.getBalance().getAmount(),0.00001);		
				
		Account t= new Account("Hamza", DKK);
		t.deposit(new Money(200, DKK));
		
		t.addTimedPayment("T1",3,2,new Money(50, DKK),SweBank,"Alice");
		t.tick();
		t.tick();
		t.tick();
		t.tick();
		t.tick();
		
		assertEquals(150,t.getBalance().getAmount(),0.00001);
		
	}

	@Test
	public void testWithdraw() {
		Account t= new Account("Hamza", DKK);
		t.withdraw(new Money(200, DKK));
		
		assertEquals(-200,t.getBalance().getAmount(),0.00001);
		
		t.deposit(new Money(1000, DKK));
		t.withdraw(new Money(650, SEK));
		assertEquals(313,t.getBalance().getAmount(),0.00001);
		
		
	}
	
	@Test
	public void testDeposit() {
		Account t= new Account("Hamza", DKK);
		t.deposit(new Money(200, SEK));
		
		assertEquals(150,t.getBalance().getAmount(),0.00001);
		
		t.deposit(new Money(100, DKK));
		assertEquals(250,t.getBalance().getAmount(),0.00001);
		
		t.deposit(new Money(900, SEK));
		assertEquals(925,t.getBalance().getAmount(),0.00001);
	}
	
	@Test
	public void testGetBalance() {
		
		assertEquals(10000000,testAccount.getBalance().getAmount(),0.00001);
		
		Account t= new Account("Hafiz", SEK);
		t.deposit(new Money(100, SEK));
		
		assertEquals(100,t.getBalance().getAmount(),0.00001);
		
		t.deposit(new Money(800, SEK));
		assertEquals(900,t.getBalance().getAmount(),0.00001);
		
	}
}
