package Part1;

import org.junit.Before;

import static org.junit.Assert.*;
import org.junit.Test;


public class FibonacciTest {

	@Test
    
	public void testFib() {
		
		
		Fibonacci tester = new Fibonacci();
		assertEquals( 0, tester.fib(0));
		assertEquals( 1, tester.fib(1));
		assertEquals( 1, tester.fib(2));
		assertEquals( 2, tester.fib(3));
		assertEquals( 3, tester.fib(4));
		assertEquals( 5, tester.fib(5));
		assertEquals( 8, tester.fib(6));
		assertEquals( 13, tester.fib(7));
	}
        @Test
        public void testFib2() {
		Fibonacci tester = new Fibonacci();
		assertEquals( 21, tester.fib(8));
//		assertEquals( 1, tester.fib(1));
//		assertEquals( 1, tester.fib(2));
//		assertEquals( 2, tester.fib(3));
//		assertEquals( 3, tester.fib(4));
//		assertEquals( 5, tester.fib(5));
//		assertEquals( 8, tester.fib(6));
//		assertEquals( 13, tester.fib(7));
	}

}
