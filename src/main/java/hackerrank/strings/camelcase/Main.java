package hackerrank.strings.camelcase;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final String words = new Scanner(System.in).nextLine();
		int count = 1;
		for (final char c : words.toCharArray()) {
			if(c >= 64 && c <= 90){
				count++;
			}
		}
		System.out.println(count);
	}
}
