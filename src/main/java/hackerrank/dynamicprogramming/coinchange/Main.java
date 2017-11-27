package hackerrank.dynamicprogramming.coinchange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final int change = scanner.nextInt(), coinValuesSize = scanner.nextInt();
		final int[] coins = new int[coinValuesSize];
		for(int i=0; i < coinValuesSize; i++){
			coins[i] = scanner.nextInt();
		}

		System.out.println(calcWays(coins, change, coins.length));
		System.out.printf("change=%d, coinValuesSize=%d, coins=%s%n", change, coinValuesSize, Arrays.toString(coins));



	}

	static int calcWays(int[] coins, int change, int i) {

		if(change == 0){
			return 1;
		}
		if(change < 0){
			return 0;
		}
		if(i <= 0){
			return 0;
		}
		return calcWays(coins, change, i - 1) + calcWays(coins, change - coins[i - 1], i);
	}
}
