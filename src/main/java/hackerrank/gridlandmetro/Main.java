package hackerrank.gridlandmetro;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @see <a href="https://www.hackerrank.com/challenges/gridland-metro">Challenge Link</a>
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {

	public static void main(String[] args) {

		final List<TrainTrack>[] v = new List[1003]; // rows

		for (int i = 0; i < v.length; i++) {
			v[i] = new ArrayList<>();
		}

		final Map<Integer, Integer> mp = new TreeMap<>();

		int n, m, k, r, c1, c2, sz1, sz2;
		long ans, temp, non_emp;

		final InputStream in = System.in;
		final Scanner scanner = new Scanner(in);
		
		n = scanner.nextInt(); // rows
		m = scanner.nextInt(); // cols
		k = scanner.nextInt(); // trainTracks
		for (int i = 0; i < k; i++) {
			r = scanner.nextInt(); // rowNumber
			c1 = scanner.nextInt(); // trackStartPos
			c2 = scanner.nextInt(); // trackEndPos

			if(!mp.containsKey(r)){
				mp.put(r, mp.size());
			}
			r = mp.get(r);

			v[r].add(new TrainTrack(c1, c2));
		}

		sz1 = mp.size(); // quantity of inserted train tracks
		for(int i=1; i <= sz1; i++){
			Collections.sort(v[i]);
		}

		ans = n * m; // matrix size
		non_emp = 0;

		for( int i=1, p = 0; i <= sz1; i++ ){
			sz2 = v[i].size(); // quantity of cells of all train tracks in this row
			for(int j = 0; j < sz2; j++) {
				if(v[i].get(j).start <= p) {
					temp = v[i].get(j).end - p;
					if (temp > 0) {
						non_emp += temp;
					}
				}else if(v[i].get(j).start > p){
					non_emp += (v[i].get(j).end - v[i].get(j).start + 1);
				}
				p = Math.max(p, v[i].get(j).end);
			}
		}

		ans -= non_emp;
		System.out.println(ans);

	}

	static class TrainTrack implements Comparable<TrainTrack> {
		int start;
		int end;

		public TrainTrack(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(TrainTrack o) {
			final int startComp = Integer.compare(this.start, o.start);
			if(startComp != 0){
				return startComp;
			}
			return Integer.compare(this.end, o.end);
		}
	}
}
