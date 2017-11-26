package hackerrank.dynamicprogramming.coinchange;

import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static utils.TestUtils.getResource;

public class MainTest {

	@Test
	public void sampleInput0() throws Exception {

//		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(getResource(MainTest.class, "/sinput0.txt"));

		Main.main(new String[]{});
	}

}
