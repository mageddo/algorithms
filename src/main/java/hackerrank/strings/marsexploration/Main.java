package hackerrank.strings.marsexploration;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final char[] sos = {'S', 'O', 'S'};

		final Scanner scanner = new Scanner(System.in);
		final char[] str = scanner.nextLine().toCharArray();
		int count = 0;

		for (int i = 0; i < str.length; i += sos.length) {

			final char[] word = Arrays.copyOfRange(str, i, i + sos.length);

			for (int j = 0; j < sos.length; j++) {
				if(sos[j] != word[j]){
					count++;
				}
			}
		}
		System.out.println(count);

	}
}
