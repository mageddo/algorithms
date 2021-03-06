package hackerrank.strings.separatethenumbers;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static utils.TestUtils.*;

public class MainTest {

	@Test
	public void caseN1() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n1234\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES 1\n", new String(out.toByteArray()));

	}

	@Test
	public void caseN2() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n91011\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES 9\n", new String(out.toByteArray()));

	}

	@Test
	public void caseN3() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n99100\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("YES 99\n", new String(out.toByteArray()));

	}


	@Test
	public void caseN4() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n101103\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}


	@Test
	public void caseN5() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n010203\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}

	@Test
	public void caseN6() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n13\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}

	@Test
	public void caseN7() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn("1\n1\n".getBytes());

		Main.main(new String[]{});

		Assert.assertEquals("NO\n", new String(out.toByteArray()));

	}

	@Test
	public void case0() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(getClass(), "/input00.txt");

		Main.main(new String[]{});

		Assert.assertEquals(getResourceAsString(getClass(), "/output00.txt"), new String(out.toByteArray()));

	}

	@Test
	public void case02() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(getClass(), "/input02.txt");

		Main.main(new String[]{});

		Assert.assertEquals(getResourceAsString(getClass(), "/output02.txt"), new String(out.toByteArray()));

	}

	@Test
	public void case16() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(getClass(), "/input16.txt");

		Main.main(new String[]{});

		Assert.assertEquals(getResourceAsString(getClass(), "/output16.txt"), new String(out.toByteArray()));

	}

	@Test
	public void case20() throws Exception {

		final ByteArrayOutputStream out = setAndGetOut();
		writeToIn(getClass(), "/input20.txt");

		Main.main(new String[]{});

		Assert.assertEquals(getResourceAsString(getClass(), "/output20.txt"), new String(out.toByteArray()));

	}

}
