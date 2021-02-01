package collections;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {
		
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		/*
		Person p = persons.stream()
					.reduce(new Person("",0), (p1 ,p2) ->{
						p1.age += p2.age;
						p1.name += p2.name;
						return p1;
					});

		System.out.println(p.name + ":" + p.age ); */
		
		Integer sumAge= persons.stream().reduce(0 ,(sum ,p) -> sum+= p.age ,(sum1 ,sum2) ->sum1 + sum2 );
		
		System.out.println(sumAge ); 
	}

}
