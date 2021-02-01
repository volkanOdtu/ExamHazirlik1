package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		/*
		Integer[] employeeIds = { 1 ,2 ,3};
		
		List< Employee> emps=	Arrays.asList(employeeIds).stream().
									map(id -> new Employee(id, "employee"+ id) ).
									collect(Collectors.toList());
		
		emps.forEach(e -> System.out.println(e.getName()) );
		*/
		
		Employee[] employees= { 
								new Employee(1, "Jeff Bezos", 100000.0) ,
								new Employee(2, "Bill Gates", 200000.0) ,
								new Employee(3, "Mark Zuckerberg", 300000.0),
								new Employee(4, "Volkan Su", 250000.0) 	
								};
		
 	  List<Employee> emplList = Arrays.asList(employees);

 	  Long peopleEarningMorethanHunderdCount = emplList.stream()
										 	   	.filter(e -> e.getSalary() > 100000 )
										 	   	.count();
 	   
 	  System.out.println("100000 den daha cok kaznana kisi sayisi: " +  peopleEarningMorethanHunderdCount);
 	  
 	  
 	  Employee emp = emplList.stream()
 	   			.filter(e -> e.getSalary() > 100000)
 	   			.sorted((o1 ,o2)->  { if( o1.getSalary() > o2.getSalary() ) return 1;
 	   								  else return -1;	}  )
 	   			.findFirst()
 	   			.orElse(null);
 	   
 	  if(emp != null)
 		  System.out.println( emp.getName() + ":" + emp.getSalary() );
 	  
 	  //forEach listedeki her item i modify ediyor
//	  emplList.stream().forEach(e -> e.setSalary(e.getSalary() + 500 ));
//	  emplList.stream().forEach(e -> System.out.println(e.getSalary()));
 	   
 	   /*
 	  List<String> arrList1 = new ArrayList<String>();
      List<String> arrList2 = new ArrayList<String>();

      arrList1.add("volkan");
	  arrList1.add("jeff");
	  
	  arrList2.add("Bill");
	  arrList2.add("Mark");
	  
 	  List<List<String>> namesList=  Arrays.asList(arrList1 ,arrList2);
 	  
 	 List<String> personList= namesList.stream().flatMap(list -> list.stream())
 	  					.collect(Collectors.toList());
 	  
 	 personList.forEach(i -> System.out.println(i)); */
 	 
 	
 	  
	}

}
