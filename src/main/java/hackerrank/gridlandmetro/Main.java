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
	private static final Map<Integer, Set<Track>> TRACK_MAP = new HashMap<>();

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
				if(!TRACK_MAP.containsKey(rowNum)){
					TRACK_MAP.put(rowNum, new TreeSet<>());
				}

				// calculando se posso colocar essa track na row
				final Set<Track> tracks = TRACK_MAP.get(rowNum);
				for (final Track track : tracks) {

					if(trackStartPos >= track.getStart() && trackEndPos <= track.getEnd()){
						 // é uma track que está dentro de outra track que ja existe
						break;
					}

				}
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

		}

		System.out.println(rows * cols - TRACK_MAP.size());

	}

	static class Track {

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
	}

}