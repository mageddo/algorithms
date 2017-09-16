package geeksforgeeks.overlappingintervals;

import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import utils.TestUtils;

/**
 * @author elvis
 * @version $Revision: $<br/>
 * $Id: $
 * @since 9/15/17 7:31 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

	@InjectMocks
	private Main main;

	@Test
	public void case0() throws Exception {

		System.setIn(TestUtils.getResource(MainTest.class, "/input00.txt"));
		final ByteArrayOutputStream out = TestUtils.setAndGetOut();

		main.main(new String[]{});

		Assert.assertEquals("1 4 6 8 9 10\n1 9\n", new String(out.toByteArray()));
	}

	@Test
	public void case1() throws Exception {

		System.setIn(TestUtils.getResource(MainTest.class, "/input01.txt"));
		final ByteArrayOutputStream out = TestUtils.setAndGetOut();

		main.main(new String[]{});

		Assert.assertEquals("1 6\n", new String(out.toByteArray()));
	}

	@Test
	public void case2() throws Exception {

		System.setIn(TestUtils.getResource(MainTest.class, "/input02.txt"));
		final ByteArrayOutputStream out = TestUtils.setAndGetOut();

		main.main(new String[]{});

		Assert.assertEquals("1 100\n", new String(out.toByteArray()));
	}

}
