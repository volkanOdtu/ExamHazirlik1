package collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleArray {

	public static void main(String[] args) {
		
		List<Employee> peopleList= new ArrayList<Employee>();
		
		peopleList.add(new Employee(1, "Peter Gibbons"));
		peopleList.add(new Employee(2, "Samir Nagheenanajar"));
		peopleList.add(new Employee(3, "Michael Bolton"));
		peopleList.add(new Employee(4, "Milton Waddams"));
		
		List<String> peopleNamesList = peopleList.stream().map(Employee::getName).collect(Collectors.toList());
		Set<String> peopleNamesSet = peopleList.stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new)); 
				
		peopleNamesSet.forEach(name -> System.out.println( name));
		
		//Stream<String> s= Stream.of("apple" ,"apricot", "banana" ,"orange");
		
		
		//Map<Character ,String> m = s.collect(Collectors.toMap(s1 -> s1.charAt(0), s1 ->s1 ,(s1 ,s2) -> s1 + "|" + s2  ,LinkedHashMap::new));
		
		//m.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue() ));
		
		/*
		Stream<String[]> str = Stream.of( new String[][] {
			{"GFG" ,"GeeksForGeeks"},
			{"g" ,"geeks"},
			{"GFG" ,"GeeksForGeeks"}
		});
		
		Map<String, String> map = str.collect(Collectors.toMap(e -> e[0], e -> e[1] ,(e1 ,e2) -> e1 ,LinkedHashMap::new ));
		
		map.entrySet().forEach(item -> System.out.println(item.getKey()  + ":" +  item.getValue() ));
		*/
	}

}
