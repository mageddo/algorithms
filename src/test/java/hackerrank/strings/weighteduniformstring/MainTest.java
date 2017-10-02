package hackerrank.strings.weighteduniformstring;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static utils.TestUtils.getResourceAsString;
import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

public class MainTest {

	@Test
	public void case0() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(getClass(), "/input00.txt");

		Main.main(new String[]{});

		Assert.assertEquals(getResourceAsString(getClass(), "/output00.txt"), new String(out.toByteArray()));
	}

}
