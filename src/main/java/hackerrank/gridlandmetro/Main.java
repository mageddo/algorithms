package hackerrank.gridlandmetro;

import java.io.InputStream;
import java.util.*;

/**
 * @see <start href="https://www.hackerrank.com/challenges/gridland-metro">Challenge Link</start>
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {


	public static void main(String[] args)  {
		new Main().start();
	}

	public void start(){

		final Map<Integer, List<TrainTrack>> trackMap = new HashMap<>();
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

			if (!trackMap.containsKey(rowNum)) {
				trackMap.put(rowNum, new ArrayList<>());
			}

			trackMap.get(rowNum).add(new TrainTrack(trackStartPos, trackEndPos));

		}

		// removing overlapping tracks
		for (final List<TrainTrack> tracks : trackMap.values()) {

			Collections.sort(tracks);

			final LinkedList<TrainTrack> stack = new LinkedList<>();
			final Iterator<TrainTrack> it = tracks.iterator();
			stack.push(it.next());

			while(it.hasNext()){

				final TrainTrack current = it.next();
				final TrainTrack head = stack.getFirst();
				if(current.start > (head.end+1)){
					stack.push(current);
				}else if(current.end > head.end){
					head.end = current.end;
				}

			}
			tracks.clear();
//			Collections.reverse(stack);
			tracks.addAll(stack);
		}

		System.out.println(matrixSize - calcUsedCells(trackMap));
	}

	private int calcUsedCells(final Map<Integer, List<TrainTrack>> trackMap) {
		int usedCells = 0;
		for (final List<TrainTrack> trainTracks : trackMap.values()) {
			for (final TrainTrack trainTrack : trainTracks) {
				usedCells += trainTrack.end - trainTrack.start + 1;
			}
		}
		return usedCells;
	}

	static class TrainTrack implements Comparable<TrainTrack> {

		int start, end;

		public TrainTrack(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(TrainTrack o) {
			return Integer.compare(this.start, o.end);
		}

		@Override
		public String toString() {
			return "{start: " + start + ", end: " + end + "}";
		}
	}

}
