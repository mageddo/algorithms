package hackerrank.gridlandmetro;

import java.math.BigInteger;
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

		final Scanner scanner = new Scanner(System.in);

		final Map<Integer, List<TrainTrack>> trackMap = new LinkedHashMap<>();
		final int rows = scanner.nextInt(); // n
		final int cols = scanner.nextInt(); // m
		final BigInteger matrixSize = BigInteger.valueOf(rows).multiply(BigInteger.valueOf(cols));
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
		for (final Integer rowNum : trackMap.keySet()) {

			final List<TrainTrack> tracks = trackMap.get(rowNum);

			Collections.sort(tracks);

			final LinkedList<TrainTrack> mergedTracks = new LinkedList<>();

			final Iterator<TrainTrack> it = tracks.iterator();

			// put head element to be compared
			mergedTracks.push(it.next());

			while(it.hasNext()){

				final TrainTrack head = mergedTracks.getFirst();
				final TrainTrack current = it.next();

				// If have a gap between HEAD and NEXT then add it to stack  as the HEAD
				if(current.start > head.end){
					mergedTracks.push(current);
				}else if(current.end > head.end){
					// If the two are overlapping then just set the head end with the next val (because List is sorted)
					head.end = current.end;
				}

			}
			tracks.clear();
			// in this algorithm show intervals in  crescent order is not necessary
//			Collections.reverse(mergedTracks);

			// replace current list with merged overlaps
			tracks.addAll(mergedTracks);
		}
		System.out.println(matrixSize.subtract(calcUsedCells(trackMap)));
	}

	private BigInteger calcUsedCells(final Map<Integer, List<TrainTrack>> trackMap) {
		BigInteger usedCells = BigInteger.ZERO;
		for (final List<TrainTrack> trainTracks : trackMap.values()) {
			for (final TrainTrack trainTrack : trainTracks) {
				usedCells = usedCells.add(BigInteger.valueOf(trainTrack.end).subtract(BigInteger.valueOf(trainTrack.start)).add(BigInteger.ONE));
			}
		}
		return usedCells;
	}

	static class TrainTrack implements Comparable<TrainTrack> {

		long start, end;

		public TrainTrack(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(TrainTrack o) {
			return Long.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "{start: " + start + ", end: " + end + "}";
		}
	}

}
