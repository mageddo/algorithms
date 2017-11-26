package geeksforgeeks.dynamicprogramming.ncr;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @see <a href="https://practice.geeksforgeeks.org/problems/ncr/0">Problem</a><br />
 * <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial Coefficient</a><br />
 * <img src="https://i.imgur.com/RxPnAAJ.png" />
 */
public class Main {
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final int testCases = scanner.nextInt(); // T

		for (int i = 0; i < testCases; i++) {
			System.out.println(ncr(scanner.nextInt(), scanner.nextInt()));
		}

	}

	static BigInteger ncr(int n, int r) {
		final BigInteger ncr = factorial(n).divide(
			factorial(r).multiply(
				factorial(n - r)
			)
		);
		return ncr;
	}

	static BigInteger factorial(int n) {
		return factorial(new BigInteger[n + 1], n);
	}

	/**
	 * https://en.wikipedia.org/wiki/Factorial
	 * @param fat
	 * @param n
	 * @return
	 */
	static BigInteger factorial(BigInteger[] fat, int n) {

		if (BigInteger.ONE.equals(fat[0])) {
			return fat[n];
		}

		fat[0] = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			fat[i] = fat[i - 1].multiply(BigInteger.valueOf(i));
		}
		return fat[n];
	}
}
