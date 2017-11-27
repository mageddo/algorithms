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

		System.out.println(calcWays(coins, change, coins.length, ""));
		System.out.printf("change=%d, coinValuesSize=%d, coins=%s%n", change, coinValuesSize, Arrays.toString(coins));



	}

	static int calcWays(int[] coins, int change, int i, String c) {

		final int coin = i > 0 ? coins[i - 1] : -1;
		System.out.printf("%scoin=%d, change=%d", c, coin, change);
		if(change == 0){
			System.out.println(", r=1");
			return 1;
		}
		if(change < 0){
			System.out.println(", r=0");
			return 0;
		}
		if(i <= 0){
			System.out.println(", r=0");
			return 0;
		}
		System.out.println();
		return
			/*
				Faz a chamada recursiva para todas as moedas possiveis (vide i -1)
				para que a outra chamada recursiva possa calcular o troco
			 */
			calcWays(coins, change, i - 1, c)
			+

			/*
				Calcula a sobra do troco com a moeda atual e
				manda para que seja calculado o troco novamente com a mesma moeda
			 */
			calcWays(coins, change - coin, i, c + "\t");
	}
}
