package collections;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class comparingByKeyValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employeesList = new ArrayList<Employee>();
		
		employeesList.add(new Employee(1, "Peter Gibbons"));
		employeesList.add(new Employee(2, "Samir Nagheenanajar"));
		employeesList.add(new Employee(3, "Michael Bolton"));
		employeesList.add(new Employee(4, "Milton Waddams"));
	
		//Once Employee classindan ArrayList Map e cevriliyor,id ve Employee objesi tutularak
		//Map<Integer, Employee> employeesMap = employeesList.stream().collect(Collectors.toMap(Employee::getId ,Function.identity()) );
		
		Map<Integer , String> employeeMap = employeesList
												.stream()
												.collect(Collectors.toMap(Employee::getId, Employee::getName));
		/*									
		Map<Integer , String> employeeMapSortedTry = employeeMap
													.entrySet()
													.stream()
													.sorted(Map.Entry.comparingByKey())
													.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue() , (e1, e2) -> e2));
				
		System.out.println(employeeMapSortedTry ); // Dogru sorted degil key e gore
		*/
		Map<Integer , String>  employeeMapSorted =employeeMap
													.entrySet()
													.stream()
													//.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
													.sorted( Collections.reverseOrder(Map.Entry.comparingByKey() ))
													.collect(Collectors.toMap( Map.Entry::getKey ,Map.Entry::getValue ,(o1 ,o2) -> o1, LinkedHashMap::new ));
													//.collect(Collectors.toMap(e->e.getKey(), e->e.getValue() ,(e1 ,e2) -> e1 ,LinkedHashMap::new ));
											
		System.out.println(employeeMapSorted ); //Simdi insertion order a gore sorted
		
		
		//Elimizdeki EmployeesMap i key e gore sort ediyoruz
		/*employeesMap.
			entrySet().
			stream().
			sorted(Map.Entry.comparingByKey()).
			forEach(item-> System.out.println(item.getKey() + ":"+ item.getValue()));
		
		
		//Value ya gore sort ediyoruz ,value(Employee) nin name ine gore
		employeesMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(comparing(Employee::getName).reversed()))
			.forEach(item-> System.out.println(item.getKey() + ":"+ item.getValue()));
		
		//Value ye gore ters order li sort
		employeesMap.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(comparing(Employee::getName).reversed()))
		.forEach(item-> System.out.println(item.getKey() + ":"+ item.getValue()));
	
		
		/*
		//Elimizdeki EmployeesMap i key e gore reverse olarak sort ediyoruz	
		employeesMap.
			entrySet().
			stream().
			sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
			forEach(item-> System.out.println(item.getKey() + ":"+ item.getValue()));
		*/

	}

}
