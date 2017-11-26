package hackerrank.dynamicprogramming.coinchange;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final int changeValue = scanner.nextInt(), coinValuesSize = scanner.nextInt();
		final int[] coinValues = new int[coinValuesSize];
		for(int i=0; i < coinValuesSize; i++){
			coinValues[i] = scanner.nextInt();
		}

		System.out.println(calcChange(coinValues, changeValue, 0, 0));

		System.out.printf("changeValue=%d, coinValuesSize=%d, coinValues=%s%n", changeValue, coinValuesSize, Arrays.toString(coinValues));

	}

	static int calcChange(int[] coins, int changeValue, int actualChange, int i){
		return -1;
	}
}
