package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class arrayListSorting {

	public static void main(String[] args) {
	
		List<Employee> employeesList = new ArrayList<Employee>();
		
		employeesList.add(new Employee(1, "Peter Gibbons"));
		employeesList.add(new Employee(2, "Samir Nagheenanajar"));
		employeesList.add(new Employee(3, "Michael Bolton"));
		employeesList.add(new Employee(4, "Milton Waddams"));
	
		Employee foundEmployee = employeesList.stream().max(comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
		
		System.out.println("Employee max id: " + foundEmployee.getId());
		
		foundEmployee = employeesList.stream().max(comparing(Employee::getName)).orElse(Employee.DEFAULT_EMPLOYEE);
		
		System.out.println("Employee max name: " + foundEmployee.getName());
		
		List<String> employeeNames= employeesList.stream().map(Employee::getName).collect(Collectors.toList());
		
		System.out.println( employeeNames );
		
		employeeNames= employeesList.stream().map(Object::toString).collect(Collectors.toList());
		
		System.out.println( employeeNames );
		
		/*
		Employee foundEmployee = employeesList.stream().max(new Comparator<Employee>() {
	       @Override
	        public int compare(Employee e1, Employee e2) {
	            return e1.getId() - e2.getId();
	        }
	    }).orElse(Employee.DEFAULT_EMPLOYEE);
		
		System.out.println(foundEmployee.getId());
		
		foundEmployee = employeesList.stream().max(new Comparator<Employee>() {
		       @Override
		        public int compare(Employee e1, Employee e2) {
		            return e1.getName().compareTo(e2.getName());
		        }
		    }).orElse(Employee.DEFAULT_EMPLOYEE);
		
		employeesList.stream().max(comparingInt(arg0))
		
		System.out.println(foundEmployee.getName() );*/
		
	}

}

class Employee{
	private int id ;
	private String name;
	double salary;
	
	public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "Default Name");
	
	public Employee(int id ,String name) {
		this.id = id;
		this.name = name;				
	}
	public Employee(int id ,String name ,double salary) {
		this.id = id;
		this.name = name;				
		this.salary= salary;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}