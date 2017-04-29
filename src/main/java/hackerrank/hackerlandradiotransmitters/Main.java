package hackerrank.hackerlandradiotransmitters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 4/28/17 8:23 PM
 */
public class Main {

//    https://www.hackerrank.com/challenges/hackerland-radio-transmitters

	public static void main(String[] args) {

//		final InputStream in = new FileInputStream(new File("/home/elvis/Downloads/input06.txt"));
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

		int usedTransmissors = 0;
		// montando a lista e setando as casas nas posicoes corretas
		Arrays.sort(positions);
		final List<Integer> street = new ArrayList<>(Arrays.asList(new Integer[positions[positions.length - 1]]));
		for (int housePostion : positions) {
			street.set(housePostion - 1, housePostion);
		}

		while (!streetClean(street)) {

			final int bestTransmissorIndex = findBestTransmissorIndex(transmissorRange, street);
			for (int i = getMinIndex(transmissorRange, bestTransmissorIndex);
					 i < getMaxIndex(street.size(), transmissorRange, bestTransmissorIndex);
					 i++
				) {
				street.set(i, null);
			}
			usedTransmissors++;
		}

		return usedTransmissors;

	}

	private static boolean streetClean(List<Integer> street) {

		for (Integer integer : street) {
			if (integer != null) {
				return false;
			}
		}
		return true;
	}

	public static int findBestTransmissorIndex(int transmissorRange, List<Integer> street) {

		int bestTransmissorIndex = -1;
		int bestTransmissorRange = -1;

		for (int i = 0; i < street.size(); i++) { // I é o indice do transmissor

			int housesQtd = 0;
			if (street.get(i) == null) {
				continue;
			}

			// procurando quantas casas o transmissor pode atender se estiver na posicao I
			for (
				int j = getMinIndex(transmissorRange, i); // J é o indice da casa que o transmissor pode atender
				j < getMaxIndex(street.size(), transmissorRange, i);
				j++
				) {
				//                if ( j == i){
				//                    continue;
				//                }

				if (street.get(j) != null) {
					housesQtd++;
				}

			}
			if (housesQtd == transmissorRange * 2 + 1) {
				bestTransmissorIndex = i;
				break;
			}
			if (housesQtd > bestTransmissorRange) {
				bestTransmissorRange = housesQtd;
				bestTransmissorIndex = i;
			}
		}
		return bestTransmissorIndex;
	}

	public static int getMinIndex(int transmissorRange, int i) {
		return i - transmissorRange < 0 ? 0 : i - transmissorRange;
	}

	private static int getMaxIndex(int size, int transmissorRange, int i) {

		if (i + transmissorRange >= size) {
			return size;
		}
		return i + transmissorRange + 1;
	}
}