package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Full2 {

	//Sehirde Okul icinde katlar ,katlarda siniflar ,siniflarda ogrenciler
	public static void main(String[] args) {
		Student s1 = new Student("Ramiz", 18, 3455, 60.75, new School("ODTU", "Ankara"));
		Student s111 = new Student("Ruknettin", 18, 3455, 60.75, new School("ODTU", "Ankara"));		
		Student s112 = new Student("Reyhan", 18, 3455, 60.75, new School("ODTU", "Ankara"));
		Student s113 = new Student("Ragip", 18, 3455, 60.75, new School("ODTU", "Ankara"));
		
		Student s2 = new Student("Murtaza", 22, 1459, 65.20, new School("ODTU", "Ankara"));
		Student s211 = new Student("Zeynep", 22, 1459, 65.20, new School("ODTU", "Ankara"));		
		Student s3 = new Student("Selim", 19, 3455, 60.75, new School("ODTU", "Ankara"));
		Student s311 = new Student("Sabiha", 19, 3455, 60.75, new School("ODTU", "Ankara"));		
		Student s4 = new Student("Arif", 22, 1459, 65.20, new School("ODTU", "Ankara"));
		
		Student s5 = new Student("Kamil", 21, 3455, 60.75, new School("ODTU", "Ankara"));
		Student s6 = new Student("Ferhat", 18, 1459, 65.20, new School("ODTU", "Ankara"));
		Student s7 = new Student("Emel", 20, 3455, 60.75, new School("ODTU", "Ankara"));
		Student s8 = new Student("Leyla", 21, 1459, 65.20, new School("ODTU", "Ankara"));
		
		
		Student s9 = new Student("Tahir", 22, 3252, 65.80, new School("Bogazici", "Istanbul"));		
		Student s10 = new Student("Aydin", 20, 4450, 70.25, new School("Bogazici", "Istanbul"));
		Student s11 = new Student("Murtaza", 18, 3252, 65.80, new School("Bogazici", "Istanbul"));		
		Student s12 = new Student("Fatih", 21, 4450, 70.25, new School("Bogazici", "Istanbul"));
		Student s13 = new Student("Jessica", 18, 3252, 65.80, new School("Bogazici", "Istanbul"));		
		Student s14 = new Student("Hasan", 19, 4450, 70.25, new School("Bogazici", "Istanbul"));
		Student s15 = new Student("Gamze", 18, 3252, 65.80, new School("Bogazici", "Istanbul"));		
		Student s16 = new Student("Selma", 19, 4450, 70.25, new School("Bogazici", "Istanbul"));
		
		List<Student> studentsList1 = Arrays.asList(s1 ,s111 ,s112 ,s113 ,s2 ,s211 , s3 , s311 , s4);
		List<Student> studentsList2 = Arrays.asList(s5 ,s6 ,s7 ,s8);
		List<Student> studentsList3 = Arrays.asList(s9 ,s10 ,s11 ,s12);
		List<Student> studentsList4 = Arrays.asList(s13 ,s14 ,s15 ,s16);

		Map<Integer, List<Student>> class1 = new HashMap<Integer, List<Student>>(); 

		class1.put(5, studentsList4);
		class1.put(4, studentsList2);
		class1.put(2, studentsList3);
		class1.put(1, studentsList1);

		//1.siniftaki ogrencileri once age e isonra name e gore sort edelim
		Comparator<Student> compByAge = Comparator.comparing(Student::getName);
		Comparator<Student> compByAgeAndName = Comparator.comparing(Student::getAge).thenComparing(Student::getName); //comparing(Student::getName).thenComparing(compByAge);
		

		Map<Integer ,List<Student>> sortedMapBykeyAndList2 = class1.entrySet()
														.stream()
														.sorted(Map.Entry.comparingByKey())
														.collect(Collectors.toMap( e->e.getKey(),e ->e.getValue()));
		
		Map<Integer ,List<Student>> sortedMapBykeyAndList = class1.entrySet()
														.stream()
														.sorted(Map.Entry.comparingByKey())
														.collect(Collectors.toMap( e->e.getKey(), e-> {
																										Collections.sort(e.getValue(),compByAgeAndName); 
																										return e.getValue() ;
																										} ,(e1 ,e2) -> e1 ,LinkedHashMap::new) );
														//collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2)-> o1 ,LinkedHashMap::new ));
		
		
		sortedMapBykeyAndList.
			entrySet().
			stream().
			forEach(item -> { System.out.println( item.getKey() + "--------------" );
							item.getValue().forEach(i -> System.out.println(i.getAge() + "-" + i.getName())); 	});
		
			
	}

	
	static class Student{
		String name;
		int age;
		long homeDistance;
		double weight;
		School school;
		
		public Student(String name , int age , long homeDistance , double weight , School school) {
			this.name = name;
			this.age = age;
			this.homeDistance = homeDistance;
			this.weight = weight;
			this.school = school;
		}

		public Student(String name ) {
			this.name = name;
		}
		public String getName() { return name; }

		public void setName(String name) { this.name = name;}

		public int getAge() { return age; }

		public void setAge(int age) { this.age = age; }

		public long getHomeDistance() { return homeDistance;}

		public void setHomeDistance(long homeDistance) { this.homeDistance = homeDistance; }

		public double getWeight() { return weight;}

		public void setWeight(double weight) { this.weight = weight; }

		public School getSchool() { return school; }

		public void setSchool(School school) { this.school = school;}
		
	}

    static class School {
		String name;
		String city;
		
		public School(String name ,String city) {			
			this.name = name;
			this.city = city;
		}

		public String getName() { return name; }
		
	    public String getCity() { return city; }
	}
}
