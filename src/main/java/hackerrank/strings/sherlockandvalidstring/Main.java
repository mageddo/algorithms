package hackerrank.strings.sherlockandvalidstring;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class Main {

	public static void main(String[] args) {

		final String s = new Scanner(System.in).nextLine();
		final Map<Character, Word> words = new HashMap<>();

		for (char c : s.toCharArray()) {

			if (!words.containsKey(c)) {
				words.put(c, new Word(c));
			}
			words.get(c).count++;

		}

		final List<Word> wordList = new ArrayList<>(words.values());
		Collections.sort(wordList);

		int leftCount = 1;

		for (int i = 0; i < wordList.size(); i++) {
			for (int j = i + 1; j < wordList.size(); j++) {

				Word a = wordList.get(i);
				Word b = wordList.get(j);

				final int diff = b.count - a.count;
				if(diff == 1){
					if(leftCount > 0){
						leftCount--;
						break;
					}else{
						System.out.println("NO");
						return ;
					}
				} else if(diff > 1){
					System.out.println("NO");
					return ;
				} else {

				}
//				System.out.println("NO");

			}
		}
		System.out.println("YES");

//		if (wordList.size() == 1) {
//			System.out.println("YES");
//			return;
//		}

//
//		for (int i = 0, j = wordList.size() - 1; i <= j; i++) {
//			int gapLeft = 1;
//
//			for (j = wordList.size(); j > i; j--) {
//
//				final Word a = wordList.get(i), b = wordList.get(j);
//				int diff = b.count - a.count;
//				if(diff > 1) {
//					System.out.println("NO");
//				} else if(diff == 1) {
//					if(gapLeft == 0) {
//						System.out.println("NO");
//					}else {
//						gapLeft--;
//					}
//				} else {
//					System.out.println("YES");
//				}
//			}
//		}

//		final Word first = wordList.getFirst();
//		final Word last = wordList.getLast();

//		if(wordList.size() == 2 ){
//			if (last.count - first.count <= 1) {
//				System.out.println("YES");
//				return;
//			}
//			System.out.println("NO");
//		} else {
//
//			if (last.count - first.count == 0){
//				System.out.println("YES");
//			} else if(last.count - first.count == 1){
//
//				final Word second = wordList.get(1);
//				if(second.count - first.count == 0){
//
//				}
//
//
//			} else {
//				System.out.println("NO");
//			}

		}

//	}


	static class Word implements Comparable<Word> {

		int count;
		final char c;

		public Word(char c) {
			this.count = 0;
			this.c = c;
		}

		@Override
		public int compareTo(Word o) {
			return Integer.compare(this.count, o.count);
		}

		@Override
		public String toString() {
			return "{" +
				"count=" + count +
				", c=" + c +
				'}';
		}
	}
}
