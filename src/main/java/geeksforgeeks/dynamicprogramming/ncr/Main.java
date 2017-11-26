package geeksforgeeks.dynamicprogramming.ncr;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.TEN;

/**
 * @see <a href="https://practice.geeksforgeeks.org/problems/ncr/0">Problem</a><br />
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

	/**
	 * <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial Coefficient</a><br />
	 * <img src="https://i.imgur.com/RxPnAAJ.png" />
	 */
	static BigInteger ncr(int n, int r) {
		if(n < r){
			return BigInteger.ZERO;
		}
		return factorialBottomUp(n).divide(
			factorialBottomUp(r).multiply(
				factorialBottomUp(n - r)
			)
		);
	}

	/**
	 * Solving factorial using top-down DP
	 * https://en.wikipedia.org/wiki/Factorial
	 * @param n
	 */
	static BigInteger factorialTopDown(int n) {

		final BigInteger[] storeTable = new BigInteger[Math.max(n + 1, 0)];
		storeTable[0] = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			storeTable[i] = storeTable[i - 1].multiply(BigInteger.valueOf(i));
		}
		return storeTable[n];
	}

	/**
	 * Solving factorial using bottom-up DP
	 * @param n
	 */
	static BigInteger factorialBottomUp(int n) {
		BigInteger lastFat = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			lastFat = lastFat.multiply(BigInteger.valueOf(i));
		}
		return lastFat;
	}
}
