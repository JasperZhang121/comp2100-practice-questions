import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorTest {
		
	@Test
	public void test1() {
		
		Calculator cal = new Calculator();
		
		assertTrue(cal.add(3, 4) == 7);
		assertTrue(cal.subtract(9, 4) == 5);
		assertTrue(cal.multiply(6, 3) == 18);
		assertTrue(cal.divide(24, 4) == 6);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test2() {
		
		Calculator cal = new Calculator();

		cal.divide(3, 0);
	}
}
