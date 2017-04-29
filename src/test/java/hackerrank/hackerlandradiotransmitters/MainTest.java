package hackerrank.hackerlandradiotransmitters;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by elvis on 28/04/17.
 */
public class MainTest {

	@Test
	public void TestFindMinimumTransmissorsSuccess() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(5, 1, new int[]{1, 2, 3, 4, 5});
		Assert.assertEquals(2, minimumTransmissors);
	}

	@Test
	public void TestFindMinimumTransmissors2Success() throws Exception {
		final int minimumTransmissors = Main.findMinimumTransmissors(8, 2, new int[]{7,2,4,6,5,9,12,11});
		Assert.assertEquals(3, minimumTransmissors);
	}

}