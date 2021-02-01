package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildcards {

	public static void main(String[] args) {
		
		List<Integer> list1 =  Arrays.asList(4 ,5, 6, 7);
		List<Double>  list2  = Arrays.asList(4.1 ,5.1, 6.1 );
		
		
		printList(list1);
		printList(list2);
		
	}
	private static void printList(List<?> argList) {
		System.out.println("Our list is:" + argList );		
		
	}
	private static void print(List<? super Integer> argList) {
		System.out.println("Our list is:" + argList );		
		
		
	}
	private static double sum(List<? extends Number> argList) {
		double sum = 0.0;
		
		for(Number i :argList)
			sum += i.doubleValue();
		
		return sum;
		
	}

}
