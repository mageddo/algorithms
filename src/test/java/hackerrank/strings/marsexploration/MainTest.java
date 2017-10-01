package hackerrank.strings.marsexploration;

import org.junit.Assert;
import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 */
public class MainTest {

	@Test
	public void caseN1() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("SOSSPSSQSSOR\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("3\n", new String(out.toByteArray()));

	}

	@Test
	public void caseN2() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("SOSSOT\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("1\n", new String(out.toByteArray()));

	}

}
