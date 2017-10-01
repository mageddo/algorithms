package hackerrank.strings.caesarcipher1;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 */


public class Main {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		scanner.nextLine();
		final String str = scanner.nextLine();
		final int shift = scanner.nextInt();

		final char sarr[] = str.toCharArray();
		for (int i=0; i < sarr.length; i++) {
			sarr[i] = cryptIt(sarr[i], shift);
		}
		System.out.println(new String(sarr));
	}

	static char cryptIt(char c, int shift) {

		if (!Character.isAlphabetic(c)){
			return c;
		}
		char base = 'A';
		if (c >= 'a') {
			base = 'a';
		}

		return (char)( (c - base + shift) % 26 /* alphabet size */ + base );
	}
}
