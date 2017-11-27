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

		System.out.println(calcWaysdp(coins, change, coins.length));
		System.out.printf("change=%d, coinValuesSize=%d, coins=%s%n", change, coinValuesSize, Arrays.toString(coins));



	}

	static int calcWaysdp(int[] coins, int change, int m) {

		final int[][] table = new int[change + 1][m];

		for (int i = 0; i < m; i++) {
			table[0][i] = 1;
		}

		for (int i = 1; i <= change; i++) {
			for (int j = 0; j < m; j++) {

				final int x,y;
				if(i - coins[j] >= 0){
					x = table[i - coins[j]][j];
				}else{
					x = 0;
				}

				if(j >= 1) {
					y = table[i][j - 1];
				}else{
					y = 0;
				}

				table[i][j] = x + y;
			}
		}
		return table[change][m - 1];

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
		final int coin = coins[i - 1];
		return
			/*
				Faz a chamada recursiva para todas as moedas possiveis (vide i -1)
				para que a outra chamada recursiva possa calcular o troco
			 */
			calcWays(coins, change, i - 1)
			+

			/*
				Calcula a sobra do troco com a moeda atual e
				manda para que seja calculado o troco novamente com a mesma moeda
			 */
			calcWays(coins, change - coin, i);
	}
}
