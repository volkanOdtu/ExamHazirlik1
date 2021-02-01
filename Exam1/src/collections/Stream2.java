package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {

	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList();
		
		intList.add(2);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(10);
		intList.add(12);
		intList.add(14);
		intList.add(16);
		
		List<Integer> intListFiltered = intList.stream().skip(3)
											.limit(2)
											.collect(Collectors.toList());
				
		System.out.println(intListFiltered);		
     
	}

}
