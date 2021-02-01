package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JoiningExample {

	public static void main(String[] args) {
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		String phrase = persons.stream().
						filter(p -> p.getAge()> 18)
						.map(p -> p.name)
						.collect(Collectors.joining(" and," , "Turkey"," is a legal age"));
		
		
//		Double peopleAgeSum = persons.stream()
				//.collect(Collectors.groupingBy(Person::getAge , Collectors.summingInt(Person::getAge) /*Collectors.counting() */));
//				.collect(Collectors.averagingDouble(Person::getAge));
		/*
		System.out.println("Total age:" + peopleAgeSum.intValue() );
		
		Map<Integer, Integer> peopleGroupedByAgeWithSum = persons.stream().
				collect(Collectors.groupingBy(Person::getAge , Collectors.summingInt(Person::getAge) ));
				
		peopleGroupedByAgeWithSum.entrySet().
				forEach( p -> System.out.println(p.getKey() + ":" +p.getValue() )); 
				
		/*Set<Person> peopleNamesStartWithP =  persons.
												stream().filter(p -> p.getName().startsWith("P") )
												.collect(Collectors.toSet()); 
		
		peopleNamesStartWithP.forEach( p-> System.out.println(p.getName() + ":" + p.getAge() ));
		
		Map<Integer, List<Person>> peopleGroupedByAge=  persons.stream()
													.collect(Collectors.groupingBy(Person::getAge)) ;
		peopleGroupedByAge.entrySet().
			forEach( p -> System.out.println(p.getKey() + ":" +p.getValue().size())); */
		

	}

}
