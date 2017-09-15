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



		// getting the pairs
		for(int i=0; i < testCases; i++){

			final List<Pair> pairs = new ArrayList<>();
			final int pairsQtd = scanner.nextInt();
			for(int j=0; j < pairsQtd; j++){
				pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
			}

			Collections.sort(pairs);
			System.out.println(pairs);
			for (int h = 0; h < pairs.size(); h++) {

			}
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
