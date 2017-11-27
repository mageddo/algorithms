package hackerrank.dynamicprogramming.coinchange;

import org.junit.Test;

import static utils.TestUtils.getResource;

public class MainTest {

	@Test
	public void sampleInput0() throws Exception {

//		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(getResource(MainTest.class, "/sinput0.txt"));

		Main.main(new String[]{});
	}


	@Test
	public void sampleInput1() throws Exception {

//		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(getResource(MainTest.class, "/sinput1.txt"));

		Main.main(new String[]{});
	}

	@Test
	public void sampleInput2() throws Exception {

//		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(getResource(MainTest.class, "/sinput2.txt"));

		Main.main(new String[]{});
	}

	@Test
	public void testCase09() throws Exception {

//		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(getResource(MainTest.class, "/input09.txt"));

		Main.main(new String[]{});
	}

}
