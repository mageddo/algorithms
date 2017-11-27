package hackerrank.dynamicprogramming.coinchange;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static java.lang.System.setIn;
import static utils.TestUtils.getResource;
import static utils.TestUtils.setAndGetOut;

public class MainTest {

	@Test
	public void sampleInput0() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		setIn(getResource(MainTest.class, "/sinput0.txt"));

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("4\n", new String(out.toByteArray()));
	}


	@Test
	public void sampleInput1() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		setIn(getResource(MainTest.class, "/sinput1.txt"));

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("5\n", new String(out.toByteArray()));
	}

	@Test
	public void sampleInput2() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		setIn(getResource(MainTest.class, "/sinput2.txt"));

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("1\n", new String(out.toByteArray()));
	}

	@Test
	public void testCase09() throws Exception {

		// arrange
		final ByteArrayOutputStream out = setAndGetOut();
		setIn(getResource(MainTest.class, "/input09.txt"));

		// act
		Main.main(new String[]{});

		// assert
		Assert.assertEquals("15685693751\n", new String(out.toByteArray()));
	}

}
