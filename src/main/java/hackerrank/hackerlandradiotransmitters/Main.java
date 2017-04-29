package hackerrank.hackerlandradiotransmitters;

import java.io.*;
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

	private static final boolean DEBUG = true;

//    https://www.hackerrank.com/challenges/hackerland-radio-transmitters

	public static void main(String[] args) throws FileNotFoundException {

		final InputStream in = new FileInputStream(new File("/home/elvis/Downloads/hackerrank/input06.txt"));
//		final InputStream in = System.in;

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
		final List<House> street = new ArrayList<>(Arrays.asList(new House[positions[positions.length - 1]]));
		for (int housePostion : positions) {

			final int index = housePostion - 1;
			if(street.get(index) == null){
				street.set(index, new House(housePostion));
			}else{
//				street.get(index).addQtd();
//				street.add(index, new House(housePostion));
			}

		}
		log(street);
		while (true) {

			final int bestTransmissorIndex = findBestTransmissorIndex(transmissorRange, street);
			if (bestTransmissorIndex == -1){
				break;
			}

//			log(
//				bestTransmissorIndex + "-" + street.subList(getMinIndex(transmissorRange, bestTransmissorIndex),
//				getMaxIndex(street.size(), transmissorRange, bestTransmissorIndex))
//			);
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


	public static int findBestTransmissorIndex(int transmissorRange, List<House> street) {

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

				final House house = street.get(j);
				if (house != null) {
					housesQtd += house.getQtd();
				}

			}
//			if (housesQtd == transmissorRange * 2 + 1) {
//				System.out.println("housesQtd == transmissorRange * 2 + 1");
//				bestTransmissorIndex = i;
//				break;
//			}
			if (housesQtd > bestTransmissorRange) {
				bestTransmissorRange = housesQtd;
				bestTransmissorIndex = i;
			}
		}
		log("index=%d, range=%d", bestTransmissorIndex, bestTransmissorRange);
		return bestTransmissorIndex;
	}

	public static int getMinIndex(int transmissorRange, int i) {
		return i - transmissorRange < 0 ? 0 : i - transmissorRange;
	}

	private static int getMaxIndex(int size, int transmissorRange, int i) {

		if (i + transmissorRange + 1 >= size) {
			return size;
		}
		return i + transmissorRange + 1;
	}

	public static int countItemsNotNull(List items){
		int count = 0;
		for (Object item : items) {
			if (item != null){
				count++;
			}
		}
		return count;
	}

	public static class House {

		/*
			this house number
		 */
		private int number;

		/**
		 * Houses quantity at this address
		 */
		private int qtd;

		public House(int number) {
			this.number = number;
			this.qtd = 1;
		}

		public void addQtd() {
			this.qtd++;
		}

		public int getQtd() {
			return qtd;
		}

//		@Override
//		public String toString() {
//			return "{" +
//				"number:" + number +
//				", qtd:" + qtd +
//				'}';
//		}
		@Override
		public String toString() {
			return String.valueOf(this.number);
		}
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

}