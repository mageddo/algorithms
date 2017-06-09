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

	private static final boolean DEBUG = true;
	private static final Map<Integer, Set<Track>> TRACK_MAP = new HashMap<>();

	public static void main(String[] args)  {

		new Main().start();

/**
 * Possivel solucao
 *
 *
 * ando pelas tracks querendo inserir c-f descubro que ja existe d-e, basta modificalo para c-f
 * descubro que em seguida tem f-g, deleto o f ficando g-g e vou seguindo procurando conflitos
 *
 */


// https://docs.google.com/spreadsheets/d/1fvsjk-EENDkTxpItwMa6HkMIIDFaFqfxEhcEeFPgw2Q/edit#gid=0
//				- nova track esta dentro de uma track existente
//				- nova track acopla duas ou mais das tracks existentes
//				- nova track junta duas tracks existentes
//				Nesse caso nao tem problema deixar as tres existindo




	}

	public void start(){
		final InputStream in = System.in;

		final Scanner scanner = new Scanner(in);
		int rows = scanner.nextInt(); // n
		int cols = scanner.nextInt(); // m
		int trainTracks = scanner.nextInt(); // k
		for (int i = 0; i < trainTracks; i++) {
			int rowNum = scanner.nextInt();
			int trackStartPos = scanner.nextInt();
			int trackEndPos = scanner.nextInt();

			for (int j = trackStartPos; j <= trackEndPos; j++) {
				if (!TRACK_MAP.containsKey(rowNum)) {
					TRACK_MAP.put(rowNum, new TreeSet<>());
				}

				// calculando se posso colocar essa track na row
				final Set<Track> tracks = TRACK_MAP.get(rowNum);
				calcTracks(tracks, trackStartPos, trackEndPos);
			}
			System.out.println(rows * cols - TRACK_MAP.size());
		}
	}

	void calcTracks(Set<Track> tracks, int trackStartPos, int trackEndPos) {

		if(tracks.isEmpty()){
			tracks.add(new Track(trackStartPos, trackEndPos));
			return ;
		}

		Track last = null;

		for (final Iterator<Track> it = tracks.iterator(); it.hasNext(); ) {

			final Track track = it.next();

			if (trackStartPos >= track.getStart() && trackEndPos <= track.getEnd()) {
				// é uma track que está dentro de outra track que ja existe
				if (trackEndPos != -1){
					log("status=current-track-inside-another");
					break;
				}else{
					last.setEnd(track.getEnd());
					it.remove();
					continue;
				}
			}

			if (trackStartPos > track.getEnd()) {
				tracks.add(new Track(trackStartPos, trackEndPos));
				break;
			}

			if (
					trackStartPos > track.getStart() && trackStartPos <= track.getEnd()
					&& trackEndPos > track.getEnd()
				) {

				track.setEnd(trackEndPos);
				trackStartPos = trackEndPos;
				trackEndPos = -1;
				last = track;
				continue;
			}

//			if (trackStartPos <= track.getStart() && trackEndPos <= track.getEnd()) {
//				track.setStart(trackStartPos);
//				track.setEnd(trackEndPos);
//				break;
//			}

//			if (trackStartPos <= track.getStart() && trackEndPos >= track.getEnd()){
//				track.setStart(trackStartPos);
//				track.setEnd(trackEndPos);
//				continue;
//			}

		}
	}

	static class Track implements Comparable<Track> {

		private int start, end;

		public Track(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		@Override
		public boolean equals(Object obj) {
			final Track t = (Track) obj;
			return t.getStart() == this.getStart() && t.getEnd() == this.getEnd();

		}

		@Override
		public String toString() {
			return "Track{" +
				"start=" + start +
				", end=" + end +
				'}';
		}

		@Override
		public int compareTo(Track o) {
			return ((Integer)(this.getStart() + this.getEnd())).compareTo(o.getStart() + o.getEnd());
		}
	}

	private static void log (Object str, Object ... args){
		if (DEBUG){
			if (str instanceof String){
				System.out.printf(str + "\n", args);
			} else {
				System.out.println(str);
			}

		}
	}

}