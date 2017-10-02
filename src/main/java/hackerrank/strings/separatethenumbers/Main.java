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
		final char[] numbers = scanner.nextLine().toCharArray();

		int casas = 1;
		int first = -1, last = -1;
		for (int i = 0; i + casas <= numbers.length; ) {

			int a = getInt(numbers, i, casas);
			int b = getInt(numbers,i + casas, casas);
			if(b == -1){
				casas++;
				continue;
			} else if (b == -2){
				int tmp = a;
				a = last;
				b = tmp;
			}

			boolean increased = false;
			if(b <= a){
				increased = true;
				if(i + casas + casas >= numbers.length){
					first = -1;
					break;
				}
				b = getInt(numbers,i + casas, ++casas);
				if(b == -1){
					continue;
				}
			}

			final int diff = b - a;
			if(diff > 1){
				if(increased){
					continue;
				}
				first = -1;
				break;
			} else if (diff == 1) {
				if (!increased){
					i += casas * 2;
				} else {
					i += casas * 2 - 1;
				}
				if(first == -1){
					first = a;
				}
				last = b;
				continue;
			}

			System.out.println("never happen");

		}

		final char[] bchars = String.valueOf(last).toCharArray();
		if(first != -1 && Arrays.equals(bchars, Arrays.copyOfRange(numbers, numbers.length - bchars.length, numbers.length))){
			System.out.printf("YES %d%n", first);
		} else {
			System.out.println("NO");
		}

	}

	private static int getInt(char[] numbers, int i, int n) {
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
