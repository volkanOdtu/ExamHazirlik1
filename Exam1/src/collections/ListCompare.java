package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCompare {

	public static void main(String[] args) {

		List<Integer> aList = Arrays.asList( 1, 3, 5, 6, 8);
		List<Integer> bList = Arrays.asList( 10, 89, 8 ,9 );
		
		//aList deki elemanlarin biri bList de var mi?
		
		boolean anItemExistsInList = aList
										.stream().anyMatch(item -> bList.contains(item));
		
		System.out.println(anItemExistsInList);//true
		
		//aList deki tum item lar bList de var mi?
		anItemExistsInList = aList
								.stream().allMatch(item -> bList.contains(item));

		System.out.println(anItemExistsInList);//false

		
		/*
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1, "Nihan Panda", 32, 200));
		employeeList.add(new Employee(2, "Mahir Sef", 36, 250));
		employeeList.add(new Employee(3, "Aydan Leyla", 22, 300));
		employeeList.add(new Employee(4, "Aydan Sakiri", 34, 700));
		employeeList.add(new Employee(5, "Peyami Galip", 30, 1200));
		
		//is all employees older than 18
		boolean result = employeeList.
								stream().
								allMatch(item -> item.getAge() > 18);

		//is there any employee whose salary is more than 500
		result = employeeList.
					stream().
					anyMatch(item -> item.getSalary() > 500);
			 
		//do we have an employee named Aydan
		result = employeeList.
				stream().
				anyMatch(item -> item.getName().contains("Aydan") );
		*/
	}
	
	static class Employee{
		int id;
		String name;
		int age;
		int salary;
		
		public Employee(int id, String name, int age, int salary) {
	        super();
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	    }
		public int getId() { return id; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public int getSalary() { return salary;}

	}

}
