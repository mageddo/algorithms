package geeksforgeeks.dynamicprogramming.ncr;

import java.math.BigInteger;

/**
 * @see <a href="https://practice.geeksforgeeks.org/problems/ncr/0">Problem</a><br />
 * <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">Binomial Coefficient</a>
 */
public class Main {
	public static void main(String[] args) {

		final int fat = 3249;

		System.out.println(factorial(fat));
	}

//	static int ncr(int n, int r) {
//		int[] fat = new int[n];
//	}

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
