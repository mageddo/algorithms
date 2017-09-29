package hackerrank.strings.sherlockandvalidstring;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

		final Map<Integer, AtomicInteger> countOfCount = new HashMap<>();
		for (final Word word : words.values()) {
			if(!countOfCount.containsKey(word.count)){
				countOfCount.put(word.count, new AtomicInteger(0));
			}
			countOfCount.get(word.count).incrementAndGet();
		}

		final List<AtomicInteger> counts = new ArrayList<>(countOfCount.values());
		counts.sort(Comparator.comparingInt(AtomicInteger::get));
		if(counts.size() <= 1){
			System.out.println("YES");
			return ;
		}

		if(counts.get(counts.size() - 1).get() > 1 && counts.get(counts.size() - 2).get() > 1){
			System.out.println("NO");
			return ;
		}

		System.out.println("YES");

	}

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
