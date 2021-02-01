package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparingByKeyExample {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		employees.add( new Employee(2, "Lokesh", "Gupta") );
		employees.add( new Employee(1, "Alex", "Gussin") );
		employees.add( new Employee(4, "Brian", "Sux") );
		employees.add( new Employee(5, "Neon", "Piper") );
		employees.add( new Employee(3, "David", "Beckham") );
		employees.add( new Employee(7, "Alex", "Beckham") );
		employees.add( new Employee(6, "Brian", "Suxena") );
        
        //Once isme ,sonra  Soyada gore sort ediyoruz listeyi
		Comparator<Employee> compByName = (e1 ,e2) ->  e1.getName().compareTo(e2.getName())  ;
		Comparator<Employee> compBySurname = (e1 ,e2) ->  e1.getSurname().compareTo(e2.getSurname())  ;
		
		
		
        Collections.sort(employees ,compBySurname.thenComparing(compByName)  );
        
        System.out.println(employees);
	}

	static class Employee{
		private int id ;
		private String name;
		private String surname;		
		
		public Employee(int id ,String name ,String surname) {
			this.id = id;
			this.name = name;				
			this.surname = surname;
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

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}
		
		@Override
		public String toString() {
			return this.id + ":" + this.name + " " + this.surname;
		}
		
		}
		
}
