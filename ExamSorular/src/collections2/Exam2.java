package collections2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Exam2 {

	static boolean allItemsExistsInGroup =false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exam2 exam = new Exam2();
		
		//List<String> group1= Arrays.asList("apple" ,"apple");
//		List<String> group2= Arrays.asList("banana" ,"anything" ,"banana");
	
		/*List<String> group1= Arrays.asList("orange");
		List<String> group2= Arrays.asList("apple" ,"apple" );
		List<String> group3= Arrays.asList("banana" ,"orange" ,"apple");
		List<String> group4= Arrays.asList("banana");*/
		
		List<String> group1= Arrays.asList("apple", "apricot");
		List<String> group2= Arrays.asList("banana" ,"anything" ,"guava");
		List<String> group3= Arrays.asList("papaya" ,"anything");
		
		List<List<String>> codeList = new ArrayList<List<String>>();
		codeList.add(group1);
		codeList.add(group2);
		codeList.add(group3);
		
		
		List<String> shoppingCart  = Arrays.asList("banana" ,"orange","guava","apple", "apricot" ,"papaya" ,"kiwi" );
		
		
		int result = exam.checkWinner(codeList ,shoppingCart);
		
	}
	public List<String> getRest(List<String> grupSearched ,List<String> shoppingCart ){
		
		List<String> remainingShoppingList = new ArrayList<String>();
				
		int cutIndex =0;
		int foundItems =0;
		boolean patternStarted = false;
		
		for(String groupItem : grupSearched) {
			
			for(int i = cutIndex ; i< shoppingCart.size() ;i++ ) {
				if(shoppingCart.get(i).equals(groupItem) || groupItem.equals("anything")) {
					patternStarted = true;
					foundItems++;					
					if( foundItems == grupSearched.size() ) {					
						allItemsExistsInGroup =true;
						remainingShoppingList = shoppingCart.subList(cutIndex + 1 ,shoppingCart.size() );
						return remainingShoppingList;
					}
					cutIndex++;	
					break;
				}else {
					if(patternStarted) {
						allItemsExistsInGroup =false;
						return null;
					}
						
				}
				
				cutIndex++;									
			}			
		}
		
		allItemsExistsInGroup = false;
		return null;
			
	}
	
	public int checkWinner(List<List<String>> codeList,  List<String> shoppingCart)
	{
		
		List<String> remainingShoppingCart = shoppingCart;
		
		for (List<String> grupList : codeList) {
			
			remainingShoppingCart = getRest(grupList, remainingShoppingCart );

			if(allItemsExistsInGroup == false)
				return 0;
			
		}
		
		return 1;
	}
}
