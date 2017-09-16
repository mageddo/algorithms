package geeksforgeeks.overlappingintervals;

import java.util.*;

/**
 * http://practice.geeksforgeeks.org/problems/overlapping-intervals/0
 *
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
			final Deque<Pair> mergedPairs = new ArrayDeque<>();
			final int pairsQtd = scanner.nextInt();
			for(int j=0; j < pairsQtd; j++){
				pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
			}

			if(pairs.isEmpty()){
				return ;
			}

			Collections.sort(pairs);
//			System.out.println(pairs);

			mergedPairs.push(pairs.get(0));

			// merging overlaps
			for (int h = 1; h < pairs.size(); h++) {

				final Pair head = mergedPairs.getFirst();
				final Pair current = pairs.get(h);
				if(current.a > head.b){
					mergedPairs.push(current);
				}else if(current.b > head.b) {
					head.b = current.b;
				}

			}

			// priting result
			String msg = "";
			Iterator<Pair> it = mergedPairs.descendingIterator();
			for (; it.hasNext() ;) {
				final Pair p = it.next();
				if (!msg.isEmpty()) {
					System.out.printf(msg);
				}
				msg = String.format("%d %d ", p.a, p.b);
			}
			System.out.println(msg.trim());

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
			return Integer.compare(this.a, o.a);
		}

		@Override
		public String toString() {
			return "{a: " + a + ", b: " + b + "}";
		}
	}
}
