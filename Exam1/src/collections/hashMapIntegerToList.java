package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class hashMapIntegerToList {

	
	public static void main(String[] args) {
	
		Map<Integer ,ArrayList<String>> mHashMap = new HashMap<Integer ,ArrayList<String>>();
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		

		list1.add("r1");
		list1.add("r4");
		
		list2.add("r2");
		list2.add("r5");
		
		list3.add("r3");
		list3.add("r6");
		
		mHashMap.put(1, list1 );
		mHashMap.put(2, list2 );
		mHashMap.put(3, list3 );
		mHashMap.put(10, list2 );
		mHashMap.put(15, list3 );
		
		//Optional<Map.Entry<Integer ,ArrayList<String>>> filteredHashMap  = mHashMap.entrySet().stream().filter(item -> item.getKey() == 1).findFirst();
		
				
		List<ArrayList<String>> foundArrayList = mHashMap.entrySet().stream().filter(item -> item.getKey() == 1).map(a -> mHashMap.get(a)).collect(Collectors.toList()); 
		
				//collect(Collectors.toMap( Map.Entry<Integer ,ArrayList<String>>>::  Function.identity(). , Function.identity() ));
		
		if( foundArrayList != null) {
			for(int i =0 ; i< foundArrayList.size() ;i++ ) {
				if( foundArrayList.get(i) != null) {
				foundArrayList.get(i).forEach( item -> {
					System.out.println("Value:" + item );							
				});
				
			}
			
		}
		
			
	}
	}

}
