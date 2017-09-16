package hackerrank.gridlandmetro;

import java.io.InputStream;
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

		final Map<Integer, List<TrainTrack>> trackMap = new HashMap<>();
		final InputStream in = System.in;
		BigInteger matrixSize = BigInteger.ZERO;

		final Scanner scanner = new Scanner(in);
		final int rows = scanner.nextInt(); // n
		final int cols = scanner.nextInt(); // m
		matrixSize = BigInteger.valueOf(rows).multiply(BigInteger.valueOf(cols));

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
//		System.out.println(trackMap.size());
		for (final Integer rowNum : trackMap.keySet()) {
			final List<TrainTrack> tracks = trackMap.get(rowNum);
			Collections.sort(tracks);

//			// priting result
//			String msg = "";
//			Iterator<TrainTrack> it = tracks.iterator();
//			System.out.println(tracks.size());
//			for (; it.hasNext() ;) {
//				final TrainTrack p = it.next();
//				if (!msg.isEmpty()) {
//					System.out.printf(msg);
//				}
//				msg = String.format("%d %d ", p.start, p.end);
//			}
//			System.out.println(msg.trim());

			final LinkedList<TrainTrack> mergedTracks = new LinkedList<>();
			final Iterator<TrainTrack> it = tracks.iterator();
			mergedTracks.push(it.next());

			while(it.hasNext()){

				final TrainTrack current = it.next();
				final TrainTrack head = mergedTracks.getFirst();
				if(current.start > head.end){
					mergedTracks.push(current);
				}else if(current.end > head.end){
					head.end = current.end;
				}

			}
			tracks.clear();
			Collections.reverse(mergedTracks);
			tracks.addAll(mergedTracks);
		}


//		for (final List<TrainTrack> tracks : trackMap.values()) {
//			// priting result
//			String msg = "";
//			Iterator<TrainTrack> it = tracks.iterator();
//			for (; it.hasNext() ;) {
//				final TrainTrack p = it.next();
//				if (!msg.isEmpty()) {
//					System.out.printf(msg);
//				}
//				msg = String.format("%d %d ", p.start, p.end);
//			}
//			System.out.println(msg.trim());
//
//		}
//
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
