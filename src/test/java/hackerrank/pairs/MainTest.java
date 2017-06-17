package hackerrank.pairs;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;

/**
 * Created by elvis on 28/04/17.
 */
public class MainTest {

	@Test
	public void countPairs_Case0() throws Exception {
		final int foundPairs = Main.findPairs(2, new int[]{1, 5, 3, 4, 2});
		Assert.assertEquals(3, foundPairs);
	}

	@Test
	public void countPairs_OneNumber() throws Exception {
		final int foundPairs = Main.findPairs(2, new int[]{1});
		Assert.assertEquals(0, foundPairs);
	}


	@Test
	public void TestFindMinimumTransmissors_Case13() throws Exception {

		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(TestUtils.getResource(MainTest.class, "/input13.txt"));
		Main.main(new String[]{});
		Assert.assertEquals("43345\n", new String(out.toByteArray()));

	}

}