package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Grouping3 {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("a" ,"bb" ,"cc" ,"ddd" );
		
		
		Map<Integer ,List<String>> stringsGrouped = strings.stream()
												.collect(Collectors.groupingBy(String::length) );
		
		
		Map<Integer ,Long> stringsGroupedByCount = strings.stream().
														collect(Collectors.groupingBy(String::length ,Collectors.counting()));
		
		Optional<Map.Entry<Integer ,Long>> maxVal = stringsGroupedByCount.entrySet().stream()
														.max(Map.Entry.comparingByValue());
	   Integer result = 0;
	   
	   if( maxVal.isPresent()) result =maxVal.get().getValue().intValue();
	   
	   System.out.println("Listedeki value larin maxi:" + result );
		
		//put  ile islem yapalim
		//stringsGrouped.put(key, value)
		
		List<String> allWords = stringsGrouped.values().stream().flatMap(item -> item.stream()).collect(Collectors.toList());
		
		allWords.stream().max((o1 ,o2) -> o1.compareTo(o2) ).ifPresent( s -> System.out.println(s));
		
		LinkedHashMap upperCasedMap =		 
							stringsGrouped.entrySet()
											.stream()
											.collect(Collectors.toMap(i -> i.getKey() ,
																	  i -> ((List<String>)i.getValue()).stream().
																	  			map(item -> item.toUpperCase()).collect(Collectors.toList()),
																	  /*i -> {  
																		     List<String> resultList = new ArrayList();
																		     
																		     i.getValue().forEach(item ->{
																		    	 							resultList.add(item.toUpperCase());
																		    	 					});
																		     i.setValue(resultList);
																		     return resultList;
																		   }, */
																	  (o1 ,o2) ->o1 ,
																	  LinkedHashMap::new));

		upperCasedMap.entrySet().
					forEach(i ->  System.out.println(i ));
		
		/*stringsGrouped.values().stream().max((o1 ,o2) -> o1. ).
										ifPresent(item ->System.out.println(item) ); */
		
//		stringsGrouped.entrySet()
//						.forEach(i -> System.out.println( i.getKey() + ":" + i.getValue().size() ));
												
	}

}
