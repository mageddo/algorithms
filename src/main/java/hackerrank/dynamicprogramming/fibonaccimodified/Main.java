package hackerrank.dynamicprogramming.fibonaccimodified;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
public class Main {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println(customFibonacci(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
	}

	/**
	 * Example:
	 * <pre>
	 * t1 = 0;
	 * t2 = 1;
	 * t3 = 0 + 1² = 1;
	 * t4 = 1 + 1² = 2;
	 * t5 = 1 + 2² = 5;
	 * t6 = 2 + 5² = 27
	 * </pre>
	 * @param t1
	 * @param t2
	 * @param n
	 */
	static BigInteger customFibonacci(int t1, int t2, int n){

		final BigInteger[] table = new BigInteger[n + 1];
		table[0] = BigInteger.ZERO;
		table[1] = BigInteger.valueOf(t1);
		table[2] = BigInteger.valueOf(t2);

		for (int i = 3; i <= n; i++) {
			table[i] = table[i - 2].add(table[i - 1].pow(2));
		}
		return table[n];
	}
}
