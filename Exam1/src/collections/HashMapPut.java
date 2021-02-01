package collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapPut {

	public static void main(String[] args) {

		Map<Integer ,Integer> numberMap = new LinkedHashMap();
		
		numberMap.put(1, 100);
//		numberMap.put(2, 200);
		numberMap.put(3, 300);
		
		if(numberMap.containsKey(2)) //old fashinoned
			numberMap.replace(2, numberMap.get(1) + 50);
		
		//if(numberMap.containsKey(2))
		//	numberMap.put(2, 5000);
	
		//numberMap.compute(2, (key ,value) ->value + 500);
		
		numberMap.compute(5, (key ,val) -> val + 500); //null deger le toplanamaz ,exception alabilir
		
		numberMap.computeIfAbsent(2, (key  ) -> 7); //hic degisiklik yok
		numberMap.computeIfPresent(2, (key ,val ) -> val+ 222); // 
			
		numberMap.entrySet().forEach(i -> {
											System.out.println(i.getKey() + ":" + i.getValue()) ;
											});
		
		}
}
