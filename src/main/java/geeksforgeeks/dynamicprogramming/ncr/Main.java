package geeksforgeeks.dynamicprogramming.ncr;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.TEN;

/**
 * @see <a href="https://practice.geeksforgeeks.org/problems/ncr/0">Problem</a><br />
 * <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial Coefficient</a><br />
 * <img src="https://i.imgur.com/RxPnAAJ.png" />
 */
public class Main {

	private static final BigInteger TEN_POW_NINE_PLUS_7 = TEN.pow(9).add(BigInteger.valueOf(7));

	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final int testCases = scanner.nextInt(); // T
		for (int i = 0; i < testCases; i++) {
			final int n = scanner.nextInt(), r = scanner.nextInt();
			final BigInteger result = ncr(n, r);
			System.out.println(result.mod(TEN_POW_NINE_PLUS_7));
		}

	}

	static BigInteger ncr(int n, int r) {
		if(n < r){
			return BigInteger.ZERO;
		}
		return factorial(n).divide(
			factorial(r).multiply(
				factorial(n - r)
			)
		);
	}

	static BigInteger factorial(int n) {
		return factorial(new BigInteger[Math.max(n + 1, 0)], n);
	}

	/**
	 * https://en.wikipedia.org/wiki/Factorial
	 * @param fat table array
	 * @param n
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
