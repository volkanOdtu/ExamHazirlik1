package hatirlama;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

  class Coordinate{
	int x,y;
}

public class Hazirlik {

	
	public static void isAllUnique(String a) {
		
		String[] allChars = a.split("");
		
		
		Map<String, Long> allCharsMap = Arrays.asList(allChars).stream()
											.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())) ;
		
		//Map<String, List<String>> allCharsListMap  = Arrays.asList(allChars).stream() .collect(Collectors.groupingBy(Function.identity()) ); 
		
		Long groupedVals = allCharsMap.entrySet().stream().filter( i -> i.getValue() > 1).count();
		
		if(groupedVals > 0)
			System.out.println(groupedVals);
		else
			System.out.println("No item repeated");
	}
	
	public static void isAnagram(String s1 ,String s2) {

		String[] strArr1 = s1.split("");
		String[] strArr2 = s2.split("");
		
		Arrays.sort( strArr1);
		String res1 = Arrays.asList(strArr1).stream().reduce("" ,(o1 ,o2) -> o1 + o2);
		System.out.println("after sorting s1: " + res1 );
		
		Arrays.sort( strArr2);
		String res2 = Arrays.asList(strArr2).stream().reduce("" ,(o1 ,o2) -> o1 + o2);
		System.out.println("after sorting s2: " + res2);
		
		if(res1.equals(res2))
			System.out.println("Both strings are the same");
		else
			System.out.println("strings are different");
	
	}
	
	public static void replace(String s) {
		
		String[] strArr  = s.split("");
		
		String result =Arrays.asList(strArr).stream().map( i-> { if(i.equals(" ")) return "%20"; else return i; }).reduce("" ,(o1,o2) -> o1 + o2);
		
		System.out.println(result); 
	}
	public static boolean isPalindrome(String s) {
		
		String[] allChars = s.split("");
		String start ,end;
		
		int halfIndex = allChars.length / 2;
		
		for(int i =0 ; i< allChars.length ; i++)
		{
			if(i == halfIndex ) 
				break;
			
			start = allChars[i];
			end = allChars[allChars.length -(i +1)];
			
			if(!start.equals(end) )
				return false;
		}
		
		return true;
	}
	public static boolean oneLetterEdit(String s1 ,String s2) {
		String[] s1Arr = s1.split("");
		String[] s2Arr = s2.split("");
		
		Map<String ,Long> s1Map =   Arrays.asList(s1Arr).stream().collect(Collectors.groupingBy(Function.identity() ,Collectors.counting() ));
		Map<String ,Long> s2Map =  Arrays.asList(s2Arr).stream().collect(Collectors.groupingBy(Function.identity() ,Collectors.counting() ));
		
		Long diffSum =0L;
		
		for( Entry<String ,Long> currEntryS1 : s1Map.entrySet()) {
		
			if( s2Map.containsKey(currEntryS1.getKey())) {
				diffSum = diffSum +  Math.abs(s2Map.get(currEntryS1.getKey()) - s1Map.get(currEntryS1.getKey()));
			}
			else
				diffSum++;
			
			if(diffSum > 1) {
				System.out.println("there are more than 1 difference");
				return false;
			}
		}
		
		return true;
	}
	
	
	public static String compression(String s) {
		
		String[] strArr = s.split("");
		String currLetter = "" ,nextLetter="";
		StringBuilder result = new StringBuilder();
		int currCharCount= 0;
		
		for(int i=0 ;i< strArr.length ;i++) {
			
			currLetter = strArr[i];
			if(! (i+1 > strArr.length ))
				nextLetter = strArr[i+1];
			else {
				result.append(currLetter).append(currCharCount);
				break;
			}
			if(currLetter.equals(nextLetter))
				currCharCount++;
			else {
				result.append(currLetter).append(currCharCount);
			}
		}
		
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		
			//isAllUnique("alia");
		
			//isAnagram("mary", "army");
		
		   //replace("Mr John Smith");
			
			//isPalindrome("ala");
			//isPalindrome("tacocat");
		
			//oneLetterEdit("pale", "ple");
			//oneLetterEdit("pales", "palko");
			//oneLetterEdit("pale", "bale");
			Coordinate[][] myShape = new Coordinate[2][3];
			
			for(int y= 0; y<myShape.length ;y++) {
				for(int x= 0; x <myShape[0].length ;x++) {
					myShape[y][x] = new Coordinate();
				}
			}
			
			(myShape[0][0]).x = 0; (myShape[0][0]).y = 0;
			(myShape[0][1]).x = 1; (myShape[0][1]).y = 0;
			(myShape[0][2]).x = 2; (myShape[0][2]).y = 0;
			
			(myShape[1][0]).x = 0; (myShape[1][0]).y = 1;
			(myShape[1][1]).x = 1; (myShape[1][1]).y = 1;
			(myShape[1][2]).x = 2; (myShape[1][2]).y = 1;
			
			System.out.println(("x:" + myShape[1][2].x  + " y:" + myShape[1][2].y) ); //2:1
			System.out.println(("x:" + myShape[0][1].x  + " y:" + myShape[0][1].y) ); //1:0
			
	}

}
