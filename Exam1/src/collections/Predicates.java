package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Predicates {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

		List<Integer> evenList = intList.stream()
									 .filter(i -> i% 2 == 0)
									 .collect(Collectors.toList());
		System.out.println(evenList);
		
		
		boolean allEven = intList.stream()
									.allMatch(i -> i% 2 == 0);
		
		System.out.println("all items are even: " + allEven );
		
		boolean oneOdd = intList.stream()
							.anyMatch(i -> i% 2 == 1);

		System.out.println("at least one item is odd : " + oneOdd );
		
		boolean noneMultipleOfThree = intList.stream()
											.noneMatch(i -> i% 3 ==  0);
		
		System.out.println("none of the items can not be divisible by 3 " + oneOdd );
		
		}

}
