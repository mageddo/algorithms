package geeksforgeeks.overlappingintervals;

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
		main.main(new String[]{});
	}

}
