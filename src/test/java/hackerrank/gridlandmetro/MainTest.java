package hackerrank.gridlandmetro;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import utils.TestUtils;

/**
 * Created by elvis on 09/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

	@InjectMocks
	private Main main;

	@Test
	public void case0() throws FileNotFoundException {

		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		final ByteArrayOutputStream inArr = new ByteArrayOutputStream();
		final PrintWriter in = new PrintWriter(inArr, true);
		in.println("4 4 3");
		in.println("2 2 3");
		in.println("3 1 4");
		in.println("4 4 4");
		TestUtils.writeToIn(inArr.toByteArray());

		Main.main(new String[]{});

		Assert.assertEquals("9\n", new String(out.toByteArray()));
	}

	@Test
	public void caseInputForum() throws FileNotFoundException {

		final ByteArrayOutputStream out = TestUtils.setAndGetOut();
		System.setIn(TestUtils.getResource(MainTest.class, "/inputForum.txt"));
		Main.main(new String[]{});
		Assert.assertEquals("8\n", new String(out.toByteArray()));
	}

	@Test
	public void case6() throws FileNotFoundException {

			final ByteArrayOutputStream out = TestUtils.setAndGetOut();
			System.setIn(TestUtils.getResource(MainTest.class, "/input06.txt"));
			Main.main(new String[]{});
			Assert.assertEquals("343959391703854850\n", new String(out.toByteArray()));

	}

}
