package hackerrank.hackerlandradiotransmitters;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @see <a href="https://www.hackerrank.com/challenges/hackerland-radio-transmitters">Challenge Link</a>
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {

	private static final boolean DEBUG = false;

	public static void main(String[] args) throws FileNotFoundException {

		final InputStream in = System.in;

		final Scanner scanner = new Scanner(in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] x = new int[n];
		for (int x_i = 0; x_i < n; x_i++) {
			x[x_i] = scanner.nextInt();
		}

		final int minimumTransmissors = findMinimumTransmissors(n, k, x);
		System.out.println(minimumTransmissors);
	}

	public static int findMinimumTransmissors(int houses, int transmissorRange, int[] positions) {

		// montando a lista e setando as casas nas posicoes corretas

		Arrays.sort(positions);

		int usedTransmissors = 0;
		final int highestHouseIndex = positions[positions.length - 1];
		final Integer[] street = new Integer[highestHouseIndex];

		for (final int housePostion : positions) {

			final int index = housePostion - 1;
			if(street[index] == null){
				street[index] = housePostion;
			}

		}

		int bestTransmissorIndex = 0;
		while (true) {

			bestTransmissorIndex = findNextTransmissorIndex(street, bestTransmissorIndex, transmissorRange);
			log(street);
			if (bestTransmissorIndex == -1){
				break;
			}

//			cleanTransmissorRange(street, transmissorRange, bestTransmissorIndex);
			bestTransmissorIndex = getMaxIndex(street.length, transmissorRange, bestTransmissorIndex);
			usedTransmissors++;

		}
		return usedTransmissors;
	}

	public static int findNextTransmissorIndex(Integer[] street, int fromIndex, int transmissorRange) {

		for (int i = fromIndex; i < street.length; i++) { // I é o indice do transmissor

			if (street[i] == null) {
				continue;
			}

			int bestTransmissorRange = i;
			for(int j = i+1; j < getMaxIndex(street.length, transmissorRange, i); j++){
				if (street[j] != null){
					bestTransmissorRange = j;
				}
			}
			return bestTransmissorRange;
		}
		return -1;
	}

	private static int getMinIndex(int transmissorRange, int i) {
		return i - transmissorRange < 0 ? 0 : i - transmissorRange;
	}

	private static int getMaxIndex(int size, int transmissorRange, int i) {

		if (i + transmissorRange + 1 >= size) {
			return size;
		}
		return i + transmissorRange + 1;
	}

	private static void log (Object str, Object ... args){
		if (DEBUG){
			if (str instanceof String){
				System.out.printf(str + "\n", args);
			} else {
				System.out.println(str);
			}

		}
	}

	private static void cleanTransmissorRange(List<Integer> street, int transmissorRange, int bestTransmissorIndex) {
		for (int i = getMinIndex(transmissorRange, bestTransmissorIndex);
				 i < getMaxIndex(street.size(), transmissorRange, bestTransmissorIndex);
				 i++
			) {
			street.set(i, null);
		}
	}

}