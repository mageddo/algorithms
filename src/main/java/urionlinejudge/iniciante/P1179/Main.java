package urionlinejudge.iniciante.P1179;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by elvis on 09/07/21.
 */
public class Main {

	public static final int ARRAY_SIZE = 5;
	private static final BufferedOutputStream out = new BufferedOutputStream(System.out);
	private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws IOException {

		final int[] odd = new int[ARRAY_SIZE], even = new int[ARRAY_SIZE];
		int oddCursor = 0, evenCursor = 0;

		final var howManyNumbersToRead = 15;
		for (int i = 0; i < howManyNumbersToRead; i++) {

			final var number = Integer.parseInt(in.readLine());
			final var isEvenNumber = number % 2 == 0;

			if (isEvenNumber) {
				if (isFull(evenCursor)) {
					printArray("par", even, evenCursor);
					evenCursor = 0;
				}
				even[evenCursor++] = number;
			} else {
				if (isFull(oddCursor)) {
					printArray("impar", odd, oddCursor);
					oddCursor = 0;
				}
				odd[oddCursor++] = number;
			}

		}

		printArray("impar", odd, oddCursor);
		printArray("par", even, evenCursor);

	}

	private static void printArray(String type, int[] arr, int to) throws IOException {
		for (int i = 0; i < to; i++) {
			out.write(String.format("%s[%d] = %d\n", type, i, arr[i]).getBytes());
		}
		out.flush();
	}

	private static boolean isFull(int cursor) {
		return cursor >= ARRAY_SIZE;
	}
}
