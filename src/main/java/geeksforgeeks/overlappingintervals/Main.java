package geeksforgeeks.overlappingintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author elvis
 * @version $Revision: $<br/>
 * $Id: $
 * @since 9/15/17 7:25 PM
 */
public class Main {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final int testCases = scanner.nextInt();

		// dynamic test cases
		for(int i=0; i < testCases; i++){

		// getting the pairs
			final List<Pair> pairs = new ArrayList<>();
			final List<Pair> mergedPairs = new ArrayList<>();
			final int pairsQtd = scanner.nextInt();
			for(int j=0; j < pairsQtd; j++){
				pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
			}

			Collections.sort(pairs);
			System.out.println(pairs);

			// merging overlaps
			for (int h = 0; h < pairs.size(); h++) {

				final Pair pair1 = pairs.get(h);
				int j = h + 1;
				for (; j < pairs.size(); j++) {

					final Pair pair2 = pairs.get(j);
					if(pair2.a - pair1.b > 0){
						mergedPairs.add(new Pair(pair1.a, pairs.get(j-1).b));
						h=j-1;
						break;
					}

				}
				if(j == pairs.size()){
					mergedPairs.add(pair1);
					break;
				}
			}

			System.out.println(mergedPairs);
			System.out.println();
		}

	}

	static class Pair implements Comparable<Pair> {

		int a,b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			final int sComp = Integer.compare(this.a, o.a);
			if(sComp != 0){
				return sComp;
			}
			return Integer.compare(this.b, o.b);
		}

		@Override
		public String toString() {
			return "{a: " + a + ", b: " + b + "}";
		}
	}
}
