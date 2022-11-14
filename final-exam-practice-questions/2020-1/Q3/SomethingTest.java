import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * You are given a java class called Something, which has a method called
 * someMethod. Please implement a minimum number of test cases for testing `someMethod`
 * that are branch complete within `someMethod`. Write your test case(s) in test() method in
 * `SomethingTest.java`. You are not allowed to alter the signatures of the given
 * methods and the package structures of the given classes. Please upload the
 * `SomethingTest.java` file to Wattle for marking.
 *
 *
 * @author nanwang
 *
 */
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE

		assertEquals(123,Something.someMethod(36,36,15,15));
		assertEquals(118,Something.someMethod(36,36,10,10));
		assertEquals(47,Something.someMethod(30,30,31,16));

		// END YOUR CODE
	}
}
