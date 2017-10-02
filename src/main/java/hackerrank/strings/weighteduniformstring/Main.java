package hackerrank.strings.weighteduniformstring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final char[] word = scanner.nextLine().toCharArray();

		final Set<Integer> weights = new HashSet<>();

		char last = '\0';
		int count = 0;
		for (char c : word) {

			if(count == 0 || last == c){
				count++;
				weights.add(calcWeight(count, c));
				last = c;
			} else {
				count = 1;
				last = c;
				weights.add(calcWeight(count, c));
			}

		}

		if(count != 0){
			weights.add(calcWeight(count, last));
		}

		final int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {

			final int x = scanner.nextInt();
			if(weights.contains(x)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}

		}

	}

	static int calcWeight(int count, char c) {
		return (c - 'a' + 1) * count;
	}
}
