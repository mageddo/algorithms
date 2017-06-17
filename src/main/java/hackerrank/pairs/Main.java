package hackerrank.pairs;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @see <a href="https://www.hackerrank.com/challenges/pairs">Challenge Link</a>
 * @author elvis
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		final InputStream in = System.in;

		final Scanner scanner = new Scanner(in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] numbers = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			numbers[x_i] = scanner.nextInt();
		}

		final int pairs = findPairs(k, numbers);
		System.out.println(pairs);
	}

	public static int findPairs(int k, int[] numbers) {

		Arrays.sort(numbers);
		int pairs = 0;
		if(numbers.length == 1){
			return pairs;
		}
		for (int i = 0; i < numbers.length; i++) {

			for(int j = i + 1; j < numbers.length; j++){
				int a = numbers[i], b = numbers[j], diff = b - a;

				if(diff > k){
					break;
				} else if(diff == k) {
					pairs++;
				}
			}

		}
		return pairs;
	}


}