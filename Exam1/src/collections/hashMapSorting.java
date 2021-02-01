package collections;

import java.util.Collections; 
import java.util.Comparator; 
import java.util.HashMap; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import static java.util.stream.Collectors.*; 
import static java.util.Map.Entry.*;


public class hashMapSorting {

	public static void main(String[] args) {
		
		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utlity", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);
		

		//Map<String, Integer> sortedBudget = budget.entrySet().stream().sorted(comparingByKey)		
		
	}

}
