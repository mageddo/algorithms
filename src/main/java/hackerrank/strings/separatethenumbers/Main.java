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
			final long first = checkIntervalOfOne(numbers);
			if(first == -1){
				System.out.println("NO");
			} else {
				System.out.printf("YES %d%n", first);
			}
		}

	}

	static long checkIntervalOfOne(char[] numbers) {

		long first = -1;

		if(numbers.length == 1 || numbers[0] == '0'){
			return first;
		}

		int places = 1;
		do {

			first = checkInterval(numbers, places);
			if(first != -1){
				return first;
			}
			places++;

		}while (numbers.length / places >= 2);

		return first;
	}

	private static long checkInterval(char[] numbers, int places) {

		long first = -1;
		long last = getNumber(numbers, 0, places);
		for (int i = places; i < numbers.length;) {

			if(numbers.length - places < places) {
				return -1;
			}

			long b = getNumber(numbers, i, places);

			// number could not be parsed
			if(b <= 0){
				return -1;
			}

			// b is smaller then need a one more place
			if(b < last){
				b = getNumber(numbers, i, ++places);
				if(b <= 0){
					return -1;
				}
			}

			final long diff = b - last;

			if(diff > 1 || diff == 0){

				// if the difference is more than one or the two are equal then this configuration will not be valid, try start
				// with a greater place size
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

	/**
	 * Get a number from the specified range of the array
	 * @param numbers
	 * @param from - inclusive
	 * @param to - exclusive
	 * @return
	 */
	private static long getNumber(char[] numbers, int from, int to) {

		// checking if it overflow long value
		if (to > 19 - 1){
			return -3;
		}
		// checking the index overflow array size
		if(from + to > numbers.length){
			return -2;
		}

		// leading zeros are not allowed
		if(numbers[from] == '0'){
			return -1;
		}

		// parsing the char array into a long number
		return Long.parseLong(new String(
			Arrays.copyOfRange(numbers, from, from + to)
		));

	}
}
