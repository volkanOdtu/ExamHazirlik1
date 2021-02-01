package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;



public class grouping {

	public static void main(String[] args) {

		List<String> stringArrList = new ArrayList<String>();
		
		stringArrList.add("a");
		stringArrList.add("bb");
		stringArrList.add("bb");		
		stringArrList.add("cc");
		stringArrList.add("ddd");
		
		Map<String ,Long> groupedMapByCount = stringArrList.
									stream().
									collect(Collectors.groupingBy(Function.identity() ,Collectors.counting() ));
		
		LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();
		/*
		groupedMapByCount
			.entrySet()
			.stream()
			.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			//.sorted( Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEach(item -> System.out.println( item.getKey() + ":" + item.getValue() )); */
			
		/*
		groupedMapByCount
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		.forEach(item ->sortedMap.put(item.getKey(), item.getValue() ));
		
		sortedMap.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue() ));
		*/		
		Map<String ,Long> resMap= groupedMapByCount
		.entrySet()
		.stream()
		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(e->e.getKey(), e->e.getValue() ,(e1 ,e2) -> e1  ,LinkedHashMap::new));
		
		resMap.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue() ));
		
		
	}

}
