//package hackerrank.dynamicprogramming.coinchange;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class Main {
//	public static void main(String[] args) {
//
//		final Scanner scanner = new Scanner(System.in);
//
//		final int changeValue = scanner.nextInt(), coinValuesSize = scanner.nextInt();
//		final int[] coinValues = new int[coinValuesSize];
//		for(int i=0; i < coinValuesSize; i++){
//			coinValues[i] = scanner.nextInt();
//		}
//
//		System.out.println(calcChange(coinValues, changeValue, 0, 0));
//
//		System.out.printf("changeValue=%d, coinValuesSize=%d, coinValues=%s%n", changeValue, coinValuesSize, Arrays.toString(coinValues));
//
//	}
//
//	static int calcChange(int[] coins, int changeValue, int actualChange){
//
//		Arrays.sort(coins);
//		int[] data = new int[changeValue];
//		for (int h = 0; h < changeValue; h++) {
//			for (int i = coins.length - 1; i >= 0; i--) {
//
//			}
//		}
//
//		int sum = 0;
//		int times = 0;
//		while(sum < changeValue){
//			sum += coins[0];
//			times++;
//		}
//		return times;
//
//	}
//}
