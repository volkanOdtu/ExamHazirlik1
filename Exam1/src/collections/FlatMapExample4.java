package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import collections.Java8Full2.Student;

public class FlatMapExample4 {

	public static void main(String[] args) {

		List<Sinif> siniflar = new ArrayList<Sinif>();
		
		//3 sinif olusturuyoruz
		IntStream.range(1, 4)
					.forEach(i -> siniflar.add(new Sinif("sinif" + i )) );
		
		siniflar.forEach(sinif ->{  
								IntStream.range(1, 4)
									.forEach(i -> {
													   sinif.students.add(new Student(sinif.name + ":student" + i  ));
												   });								    
								 });
		
		siniflar.stream()
			.flatMap(sinif -> sinif.students.stream() )
			.forEach(student-> System.out.println( student.getName() ));
		
		
		List<List<Student>> listOfStudentsList = new ArrayList<List<Student>>();
		
		List<Student> studentsList1 = new ArrayList<Student>();
		studentsList1.add(new Student("ali"));
		studentsList1.add(new Student("veli"));
		studentsList1.add(new Student("sait"));
		

		List<Student> studentsList2 = new ArrayList<Student>();
		studentsList2.add(new Student("ibrahim"));
		studentsList2.add(new Student("cavit"));
		studentsList2.add(new Student("mehmet"));

		List<Student> studentsList3 = new ArrayList<Student>();
		studentsList3.add(new Student("fatih"));
		studentsList3.add(new Student("talat"));
		studentsList3.add(new Student("akif"));

		
		listOfStudentsList.add(studentsList1);
		listOfStudentsList.add(studentsList2);
		listOfStudentsList.add(studentsList3);
		
		List<Student> students =
								listOfStudentsList.
									stream().
									flatMap(studentList -> studentList.stream()).collect(Collectors.toList());
		
		System.out.println(students.size());
	}

	static class Sinif{
		String name;
		List<Student> students = new ArrayList<Student>();
		
		public Sinif(String name) {
			this.name = name;
		}
		
	}
}
