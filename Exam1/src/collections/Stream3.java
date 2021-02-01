package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Stream3 {

	public static void main(String[] args) {

		Employee[] employees= { 
				new Employee(4, "Jeff Bezos", 100000.0) ,
				new Employee(1, "Bill Gates", 200000.0) ,
				new Employee(3, "Mark Zuckerberg", 300000.0),
				new Employee(2, "Volkan Su", 250000.0) 	
				};

		List<Employee> emplList = Arrays.asList(employees);
		
		Employee employeeMinId = emplList.stream()
								 	.min((o1 ,o2) -> o1.getId() - o2.getId() )
								 	.orElseThrow(NoSuchElementException::new);

		Employee employeeHavingMaxSalary = emplList.stream()
										.max(Comparator.comparing(Employee::getSalary))
									 	.orElseThrow(NoSuchElementException::new);

		System.out.println("Max salary:" + employeeHavingMaxSalary.getSalary());
		
		List<Integer> intList = Arrays.asList( 2, 5 ,3 ,2, 4, 3);
		List<Integer> distinctList = intList.
										stream().
										distinct().
										collect(Collectors.toList());
		
										
		distinctList.forEach(i -> System.out.println(i) );
		
 		//System.out.println( "minId:" + employeeMinId.getId());
		 	//.sorted((o1 ,o2) ->o1.getName().compareTo(o2.getName()) )
		 	//.collect(Collectors.toList());

	}

}
