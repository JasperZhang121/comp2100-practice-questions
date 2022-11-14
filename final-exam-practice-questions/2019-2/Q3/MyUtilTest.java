package utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO: write a minimum number of JUnit test cases (assertEquals) for
 * {@code MyUtil.parseDouble} that is code complete.
 * 
 * @author dongwoo
 *
 */
public class MyUtilTest {

	@Test
	public void test() {
		//start your code

		assertEquals(0.0,(double) MyUtil.parseDouble(null),0.01);
		assertEquals(0.0,(double) MyUtil.parseDouble("abandon"),0.01);
		assertEquals(1234.1,(double) MyUtil.parseDouble("1234.1abandon"),0.01);

		//end your code
	}

}
