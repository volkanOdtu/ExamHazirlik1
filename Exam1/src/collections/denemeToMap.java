package collections;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class denemeToMap {

	public static Map<String ,String> listToMap(List<Book> booksList){
		Map<String ,String>	booksMap = booksList.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
	    return booksMap;
	}
	
	@Test
	public void testConversionFromListToMap() {
		
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("kitap1" ,1954 ,"0395489318"));
		bookList.add(new Book("kitap2" ,1954 ,"0345339711"));
		bookList.add(new Book("kitap3" ,1955 ,"0618129111"));
		
		
		assertTrue(denemeToMap.listToMap(bookList).size() == 3 );
	}
	
	public static void main(String[] args) {
		
		List<Book> bookList = new ArrayList<Book>();
	
		bookList.add(new Book("kitap1" ,1954 ,"0395489318"));
		bookList.add(new Book("kitap2" ,1954 ,"0345339711"));
		bookList.add(new Book("kitap3" ,1955 ,"0618129111"));
		
	    //Map<Integer ,String> booksMap =  bookList.stream().collect(Collectors.toMap(Book::getReleaseYear, Book::getName));
	    //Book a denk geliyo Function.identity() degeri
		
		/*
		Map<Integer ,Book> booksMapColl =  bookList.stream().collect(Collectors.toMap( Book::getReleaseYear ,Function.identity() ,
				(existingBook ,newBook) ->existingBook  ,ConcurrentHashMap::new));
	    
		if( booksMapColl instanceof ConcurrentHashMap)
			System.out.println("booksMapColl is a type of ConcurrentHashMap");
		else
			System.out.println("booksMapColl is not a type of ConcurrentHashMap"); */
	    
		//Map<String,Book> booksMapColl =  bookList.stream().collect(Collectors.toMap( Book::getName ,Function.identity() ,
		//		(existingBook ,newBook) ->existingBook  ,ConcurrentHashMap::new));
	    
		
		 
		Map<String,Book> booksMapColl =  bookList.stream().collect(Collectors.toMap( Book::getName ,Function.identity() 
				,(o1 ,o2) ->o1 , TreeMap::new));
	    
		booksMapColl.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue().getIsbn() ));	    
	}

	
}

