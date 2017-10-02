package hackerrank.strings.weighteduniformstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final char[] word = scanner.nextLine().toCharArray();

		final Map<String, Integer> wordMap = new HashMap<>();

		StringBuilder sb = new StringBuilder();
		for (char c : word) {

			if(sb.length() == 0 || sb.charAt(sb.length() - 1) == c){
				sb.append(c);
				wordMap.put(sb.toString(), (c - 'a' + 1) * sb.length());
			} else {
				sb = new StringBuilder();
				sb.append(c);
				wordMap.put(sb.toString(), (sb.charAt(sb.length() - 1) - 'a' + 1) * sb.length());
			}

		}

		if(sb.length() != 0){
			wordMap.put(sb.toString(), (sb.charAt(0) - 'a' + 1) * sb.length());
		}

		final HashSet<Integer> weights = new HashSet<>(wordMap.values());

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
}
