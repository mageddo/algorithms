package hackerrank.gridlandmetro;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @see <a href="https://www.hackerrank.com/challenges/gridland-metro">Challenge Link</a>
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {

	private static final boolean DEBUG = false;
	private static final Set<String> TRAIN_TRACKS_SET = new HashSet<>();

	public static void main(String[] args)  {

		final InputStream in = System.in;

		final Scanner scanner = new Scanner(in);
		int rows = scanner.nextInt(); // n
		int cols = scanner.nextInt(); // m
		int trainTracks = scanner.nextInt(); // k
		for (int i = 0; i < trainTracks; i++) {
			int rowNum = scanner.nextInt();
			int trackStartPos = scanner.nextInt();
			int trackEndPos = scanner.nextInt();

			for(int j=trackStartPos; j <= trackEndPos; j++){
				TRAIN_TRACKS_SET.add(rowNum + "-" + j);
			}

		}

		System.out.println(rows * cols - TRAIN_TRACKS_SET.size());

	}

}