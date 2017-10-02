package hackerrank.strings.separatethenumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 */
public class Main {

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);
		final int n = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < n; i++) {
			final char[] numbers = scanner.nextLine().toCharArray();
			checkIntervalOfOne(numbers);
		}

	}

	static void checkIntervalOfOne(char[] numbers) {

		if(numbers.length == 1 || numbers[0] == '0'){
			System.out.println("NO");
			return ;
		}

		int places = 1, first;
		do {

			first = checkInterval(numbers, places);
			if(first != -1){
				System.out.printf("YES %d%n", first);
				return ;
			}
			places++;

		}while (numbers.length / places >= 2);

		System.out.println("NO");

	}

	private static int checkInterval(char[] numbers, int places) {

		int first = -1;
		int last = getInt(numbers, 0, places);
		for (int i = places; i + places <= numbers.length;) {

			int b = getInt(numbers, i, places);

			if(b <= 0){
				return -1;
			}

			if(b < last){
				b = getInt(numbers, i, ++places);
				if(b <= 0){
					return -1;
				}
			}

			final int diff = b - last;
			if(diff > 1 || diff == 0){
				return -1;
			} else if(diff == 1){
				i += places;
				if(first == -1){
					first = last;
				}
				last = b;
			}
		}
		return first;
	}

	private static int getInt(char[] numbers, int i, int n) {
		if (n > 9){
			return -3;
		}
		if(i + n > numbers.length){
			return -2;
		}
		if(numbers[i] == '0'){
			return -1;
		}
		final String nstr = new String(Arrays.copyOfRange(numbers, i, i + n));
		return Integer.parseInt(nstr);
	}
}
