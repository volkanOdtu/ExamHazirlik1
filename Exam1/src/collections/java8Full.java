package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class java8Full {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList( new Person("Max", 18) ,
											 new Person("Peter", 23) ,
											 new Person("Pamela", 23) ,
											 new Person("David", 12) 	);										 
					
		//Map<Integer ,List<Person>> peopleGroupedByAge = people.stream().collect(Collectors.groupingBy(Person::getAge)); 
		
		Map<Integer ,List<Person>> peopleGroupedByAge = people.
															stream().
															collect(Collectors.groupingBy(item -> item.getAge()) );
		
		//Key e gore grupladik 
		peopleGroupedByAge.
			entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(p -> { 
																					System.out.println(  p.getKey() + ":" );
																					p.getValue().forEach(item -> System.out.println(item.name ) );																						
																				});
		//Key e gore grupladiktan sonra ,simdi value larna gore de gruplayalim
		

		Map<Integer ,List<Person>>  peopleByAgeSortedByKey =  peopleGroupedByAge.
			entrySet().
			stream().
			sorted(Map.Entry.comparingByKey()).
			collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) -> o1 ,LinkedHashMap::new));

		
		// thenComparing( (o1 ,o2) -> o1.getValue())).
		/*
		peopleByAgeSortedByKey.
			entrySet().
			stream().
			flatMap(list1 -> list1 )
			sorted(Map.Entry.comparingByValue( (o1 ,o2)-> ((Person)o1).getName().compareTo( ((Person)o2).getName()));  
			collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) -> o1 ,LinkedHashMap::new)).
			forEach(p -> { 
				System.out.println(  p.getKey() + ":" );
				p.getValue().forEach(item -> System.out.println(item.name ) );																						
			}); */
		
		//.sorted(Map.Entry.comparingByValue(comparing(Person::getName)));
				//.forEach(item -> System.out.println(item.name ) );
				
				
		
		
		
		//peopleGroupedByAge.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue().size() ) );

		/*
		Map<Integer ,Long> peopleGroupByAge = people.
												stream().
												collect(Collectors.groupingBy(item-> item.getAge(),Collectors.counting() ) );		
													//collect(Collectors.groupingBy(Person::getAge,Collectors.counting() ) );

		peopleGroupByAge.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue() ) );


		 /*
		List<Person> peopleFiltered = people.
										stream().filter(a -> a.name.startsWith("P"))
											.collect(Collectors.toList());
		

		peopleFiltered.forEach(a ->System.out.println(a.name) );
					
			
			
		
		/*
		Stream<String> lettersStream = Stream.of("d2" ,"a2" ,"b1" ,"b3" ,"c" )
											.filter(s -> s.startsWith("a"));
		
		lettersStream.anyMatch(item -> {return true;}); // calisir
		lettersStream.noneMatch(item -> {return true;}); // exception
		
		/*
		Stream.of("d2" ,"a2" ,"b1" ,"b3" ,"c")
			.map(s -> {
						System.out.println("map:" + s);
						return s.toUpperCase() ;
				     })
			.anyMatch(s -> {
						System.out.println("anyMatch:" + s);
						return s.startsWith("A");
			});
		
		/*
		Stream.of(1.0 ,2.0 ,3.0)
			.mapToInt(Double::intValue )
			.mapToObj(i -> "a" + i)
			.forEach(item ->System.out.println(item) );
			
			
		IntStream.range(1, 4)
			.mapToObj(i -> "a" + i )
			.forEach(item ->System.out.println(item) );
		
		
		
		
		Stream.of("a1" ,"a2" ,"a3")
			.map(s -> s.substring(1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(item ->System.out.println(item) );
		
		
		/*
	OptionalDouble result = Arrays.stream(new double[] { 1.0 ,2.5 ,3.0 })
			//.map(n -> 2 * n + 1)
			.average();
		
	double avgVal= 0.0;
	if( result.isPresent())
		avgVal= result.getAsDouble();
	
	System.out.println(avgVal );
	
			//.ifPresent(item ->System.out.println(item));
		
		/*
		IntStream.
			range(1, 4)
			.forEach( item -> System.out.println(item) );
		
		Arrays.asList("a1" ,"a2" ,"a3")
			.stream()
			.findFirst()
			.ifPresent(item ->System.out.println(item) );
		
		
		
		List<String> myList = Arrays.asList("a1" ,"a2" ,"b1" ,"c2" ,"c1");
		
		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			//.map(String::toUpperCase)
			.map(item -> item.toUpperCase())
			.sorted()
			//.sorted((o1 ,o2) -> o1.compareTo(o2))
			.forEach(System.out::println);
			//.forEach(item ->System.out.println(item));
		
			
		/*
		Map<Integer,String> lcMap = new HashMap<Integer, String>();
		
		lcMap.
			entrySet().
			stream().forEach(item -> item.pu);
			
		
		
		/*
		int max = 1000000;
		
		List<String> values = new ArrayList<String>(max);
		
		for(int i=0 ; i< max ; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		
		long count = values.
						stream()
						.sorted()
						.count();
		
		 /*
		final Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		
		wordCounts.put("uSA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("oppurtunity", 200);
		
		
		final Map<String, Integer> sortedWords = wordCounts.
												entrySet().
												stream().
												sorted(Map.Entry.comparingByKey())
												.collect(Collectors.toMap(item ->item.getKey(), item ->item.getValue() ,(e1 ,e2) ->e1 ,LinkedHashMap::new));
												//.collect(Collectors.toMap(Map.Entry::getKey ,Map.Entry::getValue ,(e1 ,e2)->e1 ,LinkedHashMap::new));
		
		//System.out.println(sortedWords);
		//sortedWords.entrySet().forEach(a -> System.out.println( a.getKey() + ":" + a.getValue() ));
		
		IFormula lcFormula = new IFormula() {
			
			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return a * 100 + 5;
			}
		};
		
		double result= lcFormula.calculate(100);
		//System.out.println(result);
		
		
		IConverter<String ,Integer> converter = item -> Integer.valueOf(item);
		
		Integer resultInt = converter.convert("123");
		System.out.println(resultInt);  
		
		Function<Person, String> fnPrintPersonName = p -> {  System.out.println(p.name + p.surname);
															return "";};
		fnPrintPersonName.apply(new Person("ali", "veli"));
		
		Consumer<Person> fnConsumerPrintPersonName = p -> { System.out.println(p.name + p.surname);};
		
		fnConsumerPrintPersonName.accept(new Person("ali", "veli"));
		
		Comparator<Person> comparator = (p1 ,p2) -> { int result = p1.name.compareTo(p2.name);
														System.out.println(result);
														return result; };
		
		comparator.compare(new Person("ali","bir"), new Person("bahri","iki"));
		
		Optional<String> optional = Optional.of("bam");
		
		
		List<Integer> intList = Arrays.asList(1 ,2 ,3);
		
	    int resultDeger =	intList
	    						.parallelStream()
								//.reduce( (a ,b) -> a + b);
								.reduce(0, (a ,b) -> a + b  ,Integer::sum);
	    
	    System.out.println(resultDeger);
	  
	    //resultDeger.ifPresent( a -> System.out.println(a.intValue() ));
	  
		/*
	 
		List<String> stringsList = new ArrayList<String>();
		stringsList.add("ddd2");
		stringsList.add("aaa2");
		stringsList.add("bbb1");
		stringsList.add("aaa1");
		stringsList.add("bbb3");
		stringsList.add("ccc1");
		stringsList.add("bbb3");
		
		Optional<String> reducedString = stringsList
											.stream()
											.sorted()
											.reduce((s1 ,s2) -> s1 + "#" + s2 );
		
		
		reducedString.ifPresent( System.out::println);
		
		/*
		boolean anyItemStartingWithA = stringsList
											.stream()
											.anyMatch(s -> s.startsWith("a"));
		System.out.println(anyItemStartingWithA);
		
	
		boolean allItemStartingWithA = stringsList
											.stream()
											.allMatch(s -> s.startsWith("a"));
		
		System.out.println(allItemStartingWithA);

		boolean noneItemStartingWithZ = stringsList
				.stream()
				.allMatch(s -> s.startsWith("z"));

	
		/*
		stringsList
			.stream()
			.filter(s -> s.startsWith("a"))
			.map(item -> item.toUpperCase())
			.sorted((o1 ,o2 )-> o1.compareTo(o2) )
			.forEach(System.out::println);
		
		*/
	}

}

interface IFormula{
	double calculate(int a);
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}

@FunctionalInterface
interface IConverter<F,T>{
	T convert(F from);
}

class Person{
	String name ;
	String surname;
	int age;
	
	Person(String name ,String surname){
		this.name = name;
		this.surname = surname;
	}
	Person(String name ,int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}