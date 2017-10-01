package hackerrank.strings.sherlockandvalidstring;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */
public class Main {

	public static void main(String[] args) {

		final String s = new Scanner(System.in).nextLine();
		final Map<Character, AtomicInteger> words = new HashMap<>();

		for (char c : s.toCharArray()) {

			if (!words.containsKey(c)) {
				words.put(c, new AtomicInteger(0));
			}
			words.get(c).incrementAndGet();

		}

		Map<Integer, AtomicInteger> countOfCounts = new HashMap<>();
		for (final AtomicInteger count : words.values()) {

			if(!countOfCounts.containsKey(count.get())){
				countOfCounts.put(count.get(), new AtomicInteger(0));
			}
			countOfCounts.get(count.get()).incrementAndGet();

		}

		final List<Integer> numbers = countOfCounts.values().stream().map(AtomicInteger::get).collect(Collectors.toList());
		Collections.sort(numbers);

		if(numbers.size() <= 1){
			System.out.println("YES");
			return ;
		}

		if(numbers.size() > 2){
			System.out.println("NO");
			return ;
		}

		if(numbers.get(0) > 1 && numbers.get(1) > 1){
			System.out.println("NO");
			return;
		}

		System.out.println("YES");


	}
}
