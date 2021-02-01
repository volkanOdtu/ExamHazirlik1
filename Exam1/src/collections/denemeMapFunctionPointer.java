package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class denemeMapFunctionPointer {
	
	private static List<Double> executeAndReturn( List<Double> argList ,Function<Double ,Double> fn  ){
		
		// map degistirmiyo collection i
		argList.stream().map(item -> { return fn.apply(item);});
		
		//Yeni bi collection a atarsak ,item lar degisiyo
		List<Double> result = argList.stream().map(item -> { Double res = fn.apply(item);
														     //System.out.println(res);	
														      return res; }).collect(Collectors.toList());
		
		return result;
	}
	
	public static void main(String[] abc) {
		
		Function<Double,Double> mySquareFn = x ->{ return  x *  x; };
		Function<Double,Double> myHalfFn = x ->{ return  x *  x; };
		Function<Double,Double> myIdentityFn = Function.identity();
		
		
		List<Double> numbersList = Arrays.asList(10D ,4D ,12D );
		
		
		
		//executeAndReturn(numbersList, mySquareFn).forEach(item -> System.out.println(item) );
		
		executeAndReturn(numbersList, myIdentityFn).forEach(item -> System.out.println(item) );
		
		
		//Function<Integer ,Integer > myIdentityFn = Function.identity();
		//System.out.println(myIdentityFn.apply(3));
		
		/*
		//final means the content of the variable cant be changed
		final Map<String ,Integer> wordCounts = new HashMap<>();
		
		wordCounts.put("USA", 100 );
		wordCounts.put("jobs", 200 );
		wordCounts.put("software", 50 );
		wordCounts.put("technology", 70 );
		wordCounts.put("oppurtunity", 20 );
		
		
		//Stream.of(wordCounts.keySet()).forEach(item -> System.out.println(item) ); //this is also ok
		//wordCounts.keySet().stream().forEach(item -> System.out.println(item) );
		//wordCounts.values().stream().forEach(item -> System.out.println(item) );		
		wordCounts.entrySet().stream()
							 .sorted(Map.Entry.comparingByKey())
							 .collect(Collectors.toMap(String, Integer));
							 
		//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
					 
							 
		.forEach(item ->System.out.println(item.getKey() + ":" + item.getValue() ) );
		*/
		
				
			
		
	}

}