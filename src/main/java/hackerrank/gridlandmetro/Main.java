package hackerrank.gridlandmetro;

import java.io.InputStream;
import java.util.*;

/**
 * @see <a href="https://www.hackerrank.com/challenges/gridland-metro">Challenge Link</a>
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {

	private static final boolean DEBUG = false;
	private static final Map<Integer, Set<Integer>> TRACK_MAP = new HashMap<>();

	public static void main(String[] args)  {
		new Main().start();
	}

	public void start(){

		final InputStream in = System.in;
		int matrixSize = -1;

		final Scanner scanner = new Scanner(in);
		final int rows = scanner.nextInt(); // n
		final int cols = scanner.nextInt(); // m
		matrixSize = rows * cols;

		final int trainTracks = scanner.nextInt(); // k
		for (int i = 0; i < trainTracks; i++) {

			final int rowNum = scanner.nextInt();
			final int trackStartPos = scanner.nextInt() - 1;
			final int trackEndPos = scanner.nextInt() - 1;

			if (!TRACK_MAP.containsKey(rowNum)) {
				TRACK_MAP.put(rowNum, new TreeSet<>());
			}

			addTrainTrack(TRACK_MAP.get(rowNum), trackStartPos, trackEndPos);

		}

		final int necessaryLampposts = calcLampposts(TRACK_MAP);
		System.out.println(matrixSize - necessaryLampposts);
	}

	private int calcLampposts(Map<Integer, Set<Integer>> trackMap) {
		int sum = 0;
		for (final Set<Integer> row : trackMap.values()) {
			sum += row.size();
		}
		return sum;
	}

	private void addTrainTrack(Set<Integer> trainTrack, int trackStartPos, int trackEndPos) {
		for(int i=trackStartPos; i <= trackEndPos; i++ ){
			trainTrack.add(i);
		}
	}

}
