package geeksforgeeks.dynamicprogramming.fibonacci;

import org.apache.commons.lang3.time.StopWatch;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @see <a href="http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/">the problem</a>
 */
public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		final int n = 35;

		final long recursiveTime;
		{
			final StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			final long r = fibonacci(n);

			stopWatch.stop();
			System.out.printf("m=recursive, r=%d, time=%d%n", r, stopWatch.getNanoTime());
			recursiveTime = stopWatch.getNanoTime();
		}

		final long dpTime;
		{
			final StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			final BigInteger r = fibonaccid(n);

			stopWatch.stop();
			System.out.printf("m=dp, r=%d, time=%d%n", r, stopWatch.getNanoTime());
			dpTime = stopWatch.getNanoTime();
		}

		System.out.printf("dp is %dx faster%n", recursiveTime / dpTime);

		System.exit(0);
	}

	/**
	 * Given a number n, print n-th Fibonacci Number.
	 *
	 * Using dynamic program using top down approach
	 */
	private static BigInteger fibonaccid(int n) {
		if(n <= 1){
			return BigInteger.valueOf(n);
		}
		final BigInteger[] fibos = new BigInteger[n + 1];
		fibos[0] = BigInteger.valueOf(0);
		fibos[1] = BigInteger.valueOf(1);
		for (int i = 2; i <= n; i++) {
			fibos[i] = fibos[i - 2].add(fibos[i - 1]);
		}
//		System.out.println(Arrays.toString(fibos));
		return fibos[n];
	}

	/**
	 * Given a number n, print n-th Fibonacci Number.
	 *
	 * Using recursion
	 */
	private static long fibonacci(int n) {
		if(n <= 1){
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
