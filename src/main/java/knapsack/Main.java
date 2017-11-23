package knapsack;

public class Main {

		// Returns the maximum value that can be put in a knapsack of capacity sackCapacity
		static int knapSack(final int sackCapacity, final int itemsWeight[], final int itemValues[], final int itemsLength) {

			int i, currWeight;
			final int maxWeights[][] = new int[itemsLength + 1][sackCapacity + 1];

			// Build table maxWeights[][] in bottom up manner
			for (i = 0; i <= itemsLength; i++) {
				for (currWeight = 0; currWeight <= sackCapacity; currWeight++) {

					if (i == 0 || currWeight == 0) {
						maxWeights[i][currWeight] = 0;
					} else if (itemsWeight[i - 1] <= currWeight){

						final int
							a = itemValues[i - 1] + maxWeights[i - 1][currWeight - itemsWeight[i - 1]],
							b = maxWeights[i - 1][currWeight];

						maxWeights[i][currWeight] = Math.max(a, b);

					} else {
						maxWeights[i][currWeight] = maxWeights[i - 1][currWeight];
					}
				}
			}

			return maxWeights[itemsLength][sackCapacity];
		}

		// Driver program to test above function
		public static void main(String args[]) {
			// int val[] = new int[] { 60, 100, 120 };
			// int wt[] = new int[] { 10, 20, 30 };
			int val[] = new int[] { 120,100,60 };
			int wt[] = new int[] { 30,20,10 };
			int W = 50;
			System.out.println(knapSack(W, wt, val, val.length));
		}
}
