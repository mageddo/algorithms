package hackerrank.strings.sherlockandvalidstring;

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

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("aabbcd".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}

	@Test
	public void case99() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("aabbcc".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES\n", new String(out.toByteArray()));

	}


	@Test
	public void case98() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("baacdd".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}

	@Test
	public void case97() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("aabbccc".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES\n", new String(out.toByteArray()));

	}

	@Test
	public void case96() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("abbc".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES\n", new String(out.toByteArray()));

	}


	@Test
	public void case95() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("abcccc".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES\n", new String(out.toByteArray()));

	}

}
