package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample3 {

	public static void main(String[] args) {
		Student student1 = new Student();
		
		student1.setName("volkan");
		student1.addBook("book1");
		student1.addBook("book2");
		student1.addBook("book3");
		
		Student student2 = new Student();
		
		student1.setName("ali");
		student1.addBook("book4");
		student1.addBook("book5");
		student1.addBook("book6");
		
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		
		List<String> allBooks = students
									.stream()
									.map(studnt -> studnt.getBooksSet() )
									.flatMap(books -> books.stream())
									.distinct()
									.collect(Collectors.toList());
		
		allBooks.forEach(x -> System.out.println(x) );
		
	}

	static class Student{

		String name;
		Set<String> booksSet = new HashSet<String>();
	
		public Student() {
			
		}
		public void addBook(String book) {
			booksSet.add(book);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<String> getBooksSet() {
			return booksSet;
		}

		public void setBooksSet(Set<String> booksSet) {
			this.booksSet = booksSet;
		}
		
		
	}
}
