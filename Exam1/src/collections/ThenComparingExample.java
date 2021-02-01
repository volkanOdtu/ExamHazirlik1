package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ThenComparingExample {

	public static void main(String[] args) {
		// TODO Auto-rgenerated method stub
 
		List<Book> bookLists = Arrays.asList( new Book("Sara", "book1") ,
											  new Book("Sara", "book3") ,
											  new Book("Sara", "book2") ,
											  new Book("John", "book5") ,
											  new Book("John", "book4") 											
											);
		
		//Collections.sort(bookLists ,Comparator.comparing(Book::getAuthor) );
		//bookLists.forEach(i -> System.out.println(i.getName() + ":" + i.getAuthor()));
		
		//Collections.sort(bookLists ,Comparator.comparing(Book::getAuthor).thenComparing(Book::getName) );
		//bookLists.forEach(i -> System.out.println(i.getName() + ":" + i.getAuthor()));
		 
			
	}

}
