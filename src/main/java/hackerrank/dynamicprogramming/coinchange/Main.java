//package hackerrank.dynamicprogramming.coinchange;
//
//import java.util.Arrays;
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
//		System.out.println(calcChange(coinValues, changeValue, 0));
//
//		System.out.printf("changeValue=%d, coinValuesSize=%d, coinValues=%s%n", changeValue, coinValuesSize, Arrays.toString(coinValues));
//
//	}
//
//	static int calcChange(int[] coins, int change, int i) {
//
////		Change d[/* coin value */][/* change value */] = new Change[coins.length][change];
////		d[1][1] = new Change(1);
////		d[1][2] = new Change(2);
////
////		d[2][1] = new Change(-1, change);
////		d[2][2] = new Change(1);
////		d[2][3] = new Change(1, 1);
////
////		for (int i = 0; i < change; i++) {
////
////
////		}
//
////		Change d[/* change */][/* coin value */] = new Change[coins.length][change];
////		d[1][1] = new Change(1);
////		d[2][1] = new Change(2);
////
////		d[1][2] = new Change(-1, change);
////		d[2][2] = new Change(1);
////		d[3][2] = new Change(1, 1);
//
////		for (int i = 0; i < change; i++) {
//
////			change = 4
////			coins = [1,2,3]
////			out = 4
////
////			1,1,1,1
////			1,1,2
////			2,2
////			1,3
//
////		}
//
////		if(change == 0){
////			return 1;
////		}
////		if(change < 0){
////			return 0;
////		}
////
////		return calcChange(coins, change - coins[i], i);
//
//
//
//
//		for (int j = 0; j < change; j++) {
//			for (int h = 0; h < coins.length; h++) {
//				final int coin = coins[i];
//
//				if(x[j][coin] == -1){
//					x[j][coin] =
//				}
//
//			}
//		}
//
//	}
//
//
//	static class Change {
//		int quantity, remainChange;
//
//
//		public Change(int quantity) {
//			this.quantity = quantity;
//			this.remainChange = 0;
//		}
//
//		public Change(int quantity, int remainChange) {
//			this.quantity = quantity;
//			this.remainChange = remainChange;
//		}
//	}
//}
