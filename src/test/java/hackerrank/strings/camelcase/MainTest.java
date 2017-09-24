package hackerrank.strings.camelcase;

import org.junit.Assert;
import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

public class MainTest {

	@Test
	public void case0() throws Exception {

		writeToIn("saveChangesInTheEditor".getBytes());
		final ByteArrayOutputStream out = setAndGetOut();

		Main.main(new String[]{});

		Assert.assertEquals("5\n", new String(out.toByteArray()));
	}

}
