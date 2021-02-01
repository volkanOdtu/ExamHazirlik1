package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import collections.Java8Full3.School;
import collections.Java8Full3.Student;

public class java8Full4 {

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
		
		
		Optional<Map.Entry<Integer, List<Student>>> studentsFiltered = class1.entrySet()
														.stream()
														.filter(item -> {return  item.getValue().stream().anyMatch(name -> name.getName().contains("Murtaza") );})
														.sorted(Map.Entry.comparingByKey() )
														.findFirst();
		
		studentsFiltered.ifPresent(item -> System.out.println( item.getKey() ) );
														//.collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue));
											
		/*
		studentsFiltered.entrySet().forEach(item -> { 
														System.out.println( item.getKey() + "--------"  );
														item.getValue().forEach(student -> System.out.println( student.getAge()  +  ":" + student.getSchool().getName() ));														 
													}); */
		
	}

}
