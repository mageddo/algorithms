package hackerrank.hackerlandradiotransmitters;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by elvis on 28/04/17.
 */
public class MainTest {

	@Test
	public void TestFindMinimumTransmissors_Case0() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(5, 1, new int[]{1, 2, 3, 4, 5});
		Assert.assertEquals(2, minimumTransmissors);
	}

	@Test
	public void TestFindMinimumTransmissors_Case1() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(8, 2, new int[]{7,2,4,6,5,9,12,11});
		Assert.assertEquals(3, minimumTransmissors);
	}

	@Test
	public void TestFindMinimumTransmissors_Case6() throws Exception {

		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(TestUtils.getResource(MainTest.class, "/input06.txt"));
		Main.main(new String[]{});
		Assert.assertEquals("620\n", new String(out.toByteArray()));

	}

	@Test
	public void TestFindMinimumTransmissors_Case7() throws Exception {

		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(TestUtils.getResource(MainTest.class, "/input07.txt"));
		Main.main(new String[]{});
		Assert.assertEquals("972\n", new String(out.toByteArray()));

	}


	@Test
	public void TestFindMinimumTransmissors3Success() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(7, 3, new int[]{2, 3, 4, 6, 8,9,10});
		Assert.assertEquals(2, minimumTransmissors);
	}


	@Test
	public void TestFindMinimumTransmissors5Success() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(8, 3, new int[]{7,2,4,3,6,5,12,11, 15,16});
		Assert.assertEquals(3, minimumTransmissors);
	}

	@Test
	public void TestFindMinimumTransmissors4Success() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(
			18, 10,
			new int[]{1, 2, 4,6, 12, 14,16,18, 19,23, 24, 25, 26, 31, 34, 41, 42, 43}
		);
		Assert.assertEquals(3, minimumTransmissors);
	}

}