package hackerrank.gridlandmetro;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import utils.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 * Created by elvis on 09/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainTest {

	@InjectMocks
	private Main main;

	@Test
	public void testFirstTrackCalcTracks() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);

		Assert.assertEquals(1, tracks.size());
	}

	@Test
	public void testTwoTrackCalcTracks() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);
		main.calcTracks(tracks, 1, 3);

		Assert.assertEquals("[Track{start=0, end=3}]", tracks.toString());
	}

	@Test
	public void testTrackAfterAnother() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);
		main.calcTracks(tracks, 4, 5);
		main.calcTracks(tracks, 6, 7);

		Assert.assertEquals("[Track{start=0, end=3}, Track{start=4, end=5}, Track{start=6, end=7}]", tracks.toString());
	}

	@Test
	public void testMergeTwoTracks() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);
		main.calcTracks(tracks, 6, 8);
		main.calcTracks(tracks, 2, 7);

		Assert.assertEquals("[Track{start=0, end=8}]", tracks.toString());
	}

	@Test
	public void testInsertTrackInOutOfOrder() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);
		main.calcTracks(tracks, 6, 7);
		main.calcTracks(tracks, 4, 5);

		Assert.assertEquals("[Track{start=0, end=3}, Track{start=4, end=5}, Track{start=6, end=7}]", tracks.toString());
	}

	@Test
	public void testOverrideFirstTrack() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 3);
		main.calcTracks(tracks, 6, 8);
		main.calcTracks(tracks, 2, 4);

		Assert.assertEquals("[Track{start=0, end=4}, Track{start=6, end=8}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 10, 12);
		main.calcTracks(tracks, 0, 2);

		Assert.assertEquals("[Track{start=0, end=2}, Track{start=10, end=12}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart2() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 10, 12);
		main.calcTracks(tracks, 0, 10);

		Assert.assertEquals("[Track{start=0, end=12}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart3() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 10, 12);
		main.calcTracks(tracks, 0, 11);

		Assert.assertEquals("[Track{start=0, end=12}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart4() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 0, 11);
		main.calcTracks(tracks, 11, 12);

		Assert.assertEquals("[Track{start=0, end=12}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart5() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 20, 30);
		main.calcTracks(tracks, 30, 40);
		main.calcTracks(tracks, 20, 35);

		Assert.assertEquals("[Track{start=20, end=40}]", tracks.toString());
	}

	@Test
	public void testInsertAtStart6() throws Exception {

		final Set<Main.Track> tracks = new TreeSet<>();
		main.calcTracks(tracks, 20, 100);
		main.calcTracks(tracks, 100, 120);
		main.calcTracks(tracks, 100, 150);
		main.calcTracks(tracks, 20, 80);
		main.calcTracks(tracks, 20, 60);

		Assert.assertEquals("[Track{start=0, end=12}]", tracks.toString());
	}

	@Test
	public void testGeneral() throws FileNotFoundException {

			final ByteArrayOutputStream out = TestUtils.setAndGetOut();
			System.setIn(TestUtils.getResource(MainTest.class, "/input06.txt"));
			Main.main(new String[]{});
			Assert.assertEquals("343959391703854850\n", new String(out.toByteArray()));
	}

}