package knapsack;

import java.util.ArrayList;
import java.util.List;

public class Main {

		// Returns the maximum value that can be put in a knapsack of capacity sackCapacity
		static Item knapSack(final int sackCapacity, final Item[] itemsWeight, final Item[] itemValues, final int itemsLength) {

			int i, itWeight;
			final Item maxWeights[][] = new Item[itemsLength + 1][sackCapacity + 1];

			// Build table maxWeights[][] in bottom up manner
			for (i = 0; i <= itemsLength; i++) {
				for (itWeight = 0; itWeight <= sackCapacity; itWeight++) {

					if (i == 0 || itWeight == 0) {
						maxWeights[i][itWeight] = new Item();
					} else {

						final int actualWeight = itemsWeight[i - 1].value;
						if (actualWeight <= itWeight){
								final Item
										a = Item.merge(itemValues[i - 1], maxWeights[i - 1][itWeight - actualWeight]),
										b = maxWeights[i - 1][itWeight];
								maxWeights[i][itWeight] = max(a, b);

						} else {
								maxWeights[i][itWeight] = maxWeights[i - 1][itWeight];
						}
					}
				}
			}
			return maxWeights[itemsLength][sackCapacity];
		}

	private static Item max(Item a, Item b) {
			if(a.value > b.value){
				return a;
			}
			return b;
	}

	// Driver program to test above function
		public static void main(String args[]) {
			 Item val[] = { new Item(60), new Item(100), new Item(120) };
			 Item wt[] = { new Item(10), new Item(20), new Item(30) };
			int W = 50;
			System.out.println(knapSack(W, wt, val, val.length));
		}

		static class Item {

			public Item() {
				this.value = 0;
				this.items = new ArrayList<>();
			}

			public Item(int value) {
				this.value = value;
				this.items = new ArrayList<>();
				this.items.add(value);
			}

			int value;
			List<Integer> items;


			static Item merge(Item a, Item b){
				final Item result = new Item();
				result.value = a.value + b.value;
				result.items.addAll(a.items);
				result.items.addAll(b.items);
				return result;
			}

			@Override
			public String toString() {
				final StringBuilder builder = new StringBuilder()//
					.append("{")//
					.append("value=")//
					.append(value)//
					.append(",items=")//
					.append(items)//
					.append("}");
				return builder.toString();
			}
		}
}
