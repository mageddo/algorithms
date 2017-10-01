package hackerrank.strings.marsexploration;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final char[] sos = {'S', 'O', 'S'};

		final Scanner scanner = new Scanner(System.in);
		final char[] str = scanner.nextLine().toCharArray();
		int count = 0;

		for (int i = 0; i < str.length; i++) {

				if(str[i] != sos[Math.min(i % sos.length, sos.length - 1)]) {
					count++;
				}

		}
		System.out.println(count);

	}
}
