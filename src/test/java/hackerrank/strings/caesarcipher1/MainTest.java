package hackerrank.strings.caesarcipher1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static utils.TestUtils.setAndGetOut;
import static utils.TestUtils.writeToIn;

public class MainTest {

	@Test
	public void caseN1() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("11\nmiddle-Outz\n2\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("okffng-Qwvb\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN2() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("11\nmiddle-Qutz\n1\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("njeemf-Rvua\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN3() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("12\nmiddle-QutZz\n0\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("middle-QutZz\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN4() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("12\nmiddle-QutZz\n1\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("njeemf-RvuAa\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN5() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("12\nmiddle-QutZz\n2\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("okffng-SwvBb\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN6() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("12\nmiddle-QutZz\n3\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("plggoh-TxwCc\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN7() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("12\n@123-_\n3\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("@123-_\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN8() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("3\nazf\n244\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("kjp\n", new String(out.toByteArray()));
	}

	@Test
	public void caseN9() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\nW\n87".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("F\n", new String(out.toByteArray()));

	}

	@Test
	public void case9() throws Exception {

		ByteArrayOutputStream out = setAndGetOut();
		writeToIn("53\n6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr\n87".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("6MFE95QigCLQY85mee3WH2laic1jX8s6p2iBMeODrSs6GFMuIeWWa\n", new String(out.toByteArray()));
	}



}
