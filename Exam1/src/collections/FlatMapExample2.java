package collections;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapExample2 {

	public static void main(String[] args) {
		
		List<Integer> primeNumbers = Arrays.asList( 5 ,7 ,11 ,13);
		List<Integer> oddNumbers = Arrays.asList( 1, 3, 5);
		List<Integer> evenNumbers = Arrays.asList( 2 ,4, 6, 8);
		
		List<List<Integer>> allLists =  Arrays.asList(primeNumbers ,oddNumbers ,evenNumbers );
				
		List<Integer> listOfInts = allLists
								.stream()
								.flatMap(list1 -> list1.stream())
								.collect(Collectors.toList());
		
		System.out.println(listOfInts);
		
		/*
		List<String> list = Arrays.asList("5.6" ,"7.4" ,"4", "1" ,"2.3");
		
		list.stream().map(item -> Double.parseDouble(item) ).
			forEach(item -> System.out.println(item )  );
		/*
		List<String> peopleHouseList1 = Arrays.asList("Volkan" ,"Emel" ,"Gamze" ,"Gunfer");
		List<String> peopleHouseList2 = Arrays.asList("Yigit" ,"Tugce" ,"YamanEge" );
		List<String> peopleHouseList3 = Arrays.asList("Mert" ,"Gozde" ,"Nuray" );
		List<String> peopleHouseList4 = Arrays.asList("Hatice" ,"Kemal"  );
		
		List<List<String>> allLists = new ArrayList<List<String>>();
		
		allLists.add(peopleHouseList1);
		allLists.add(peopleHouseList2);
		allLists.add(peopleHouseList3);
		allLists.add(peopleHouseList4);
		
		List<String> peopleAll = new ArrayList<String>();
		
		for(List<String> housePersons:allLists)
			for(String name:housePersons)
				peopleAll.add(name);
		
		System.out.println(peopleAll);
		
		//Listeleri stream ile process ediyoruz
		List<String> flatMapList = 
				allLists.
				stream().
				//map(list1 -> list1.stream()).
				flatMap(list1 -> list1.stream()).
				collect(Collectors.toList());
		
		System.out.println(flatMapList);        
		
		/*
		List<OneStudentCourses> manyStudentCoursesList = Arrays.asList( new OneStudentCourses("maths") ,
																		new OneStudentCourses("science") ,
																		new OneStudentCourses("social") ,																		
																		new OneStudentCourses("chemistry") ,
																		new OneStudentCourses("maths"));
		
		Map<String ,List<OneStudentCourses>> x = ( Map <String, List<OneStudentCourses>>) manyStudentCoursesList
													.stream()
													.flatMap(item -> item.getSubjects().stream().map(subject -> new AbstractMap.SimpleEntry(subject, item)  ))
													   .collect(Collectors.groupingBy(e -> ((SimpleEntry<String, OneStudentCourses>) e).getKey(), Collectors
										                        .mapping(e -> ((SimpleEntry<String, OneStudentCourses>) e).getValue(), Collectors.toList())));
		*/
	}

}

class OneStudentCourses{
	List<String> subjects = new ArrayList<String>();
	public OneStudentCourses(String course) {
		subjects.add(course);
	}
	public List<String> getSubjects(){
		return subjects;
	}
	public void setSubjects(List<String>  subjects) {
		this.subjects = subjects;
	}
}