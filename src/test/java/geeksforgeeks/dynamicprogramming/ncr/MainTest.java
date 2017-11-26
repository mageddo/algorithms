package geeksforgeeks.dynamicprogramming.ncr;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

public class MainTest {

	@Test
	public void case1() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(MainTest.class, "/input01.txt");

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("3\n", new String(out.toByteArray()));
	}

	@Test
	public void case2() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(MainTest.class, "/input02.txt");

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("10\n", new String(out.toByteArray()));
	}

	@Test
	public void factorial0(){
		Assert.assertEquals(1, Main.factorial(0).longValue());
	}

	@Test
	public void factorial1(){
		Assert.assertEquals(1, Main.factorial(1).longValue());
	}

	@Test
	public void factorial2(){
		Assert.assertEquals(2, Main.factorial(2).longValue());
	}

	@Test
	public void factorial3(){
		Assert.assertEquals(6, Main.factorial(3).longValue());
	}

	@Test
	public void factorial7(){
		Assert.assertEquals(5040, Main.factorial(7).longValue());
	}

}
