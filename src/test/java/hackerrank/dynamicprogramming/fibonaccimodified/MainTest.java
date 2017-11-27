package hackerrank.dynamicprogramming.fibonaccimodified;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

public class MainTest {

	@Test
	public void sample00() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(MainTest.class, "/s00.in");

		// act
		Main.main(new String[]{});

		//assert
		Assert.assertEquals("5\n", new String(out.toByteArray()));
	}

	@Test
	public void sample01() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(MainTest.class, "/s01.in");

		// act
		Main.main(new String[]{});

		//assert
		Assert.assertEquals("27\n", new String(out.toByteArray()));
	}

	@Test
	public void testcase01() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(MainTest.class, "/t01.in");

		// act
		Main.main(new String[]{});

		//assert
		Assert.assertEquals("84266613096281243382112\n", new String(out.toByteArray()));

	}

}
