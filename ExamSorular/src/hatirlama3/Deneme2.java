package hatirlama3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Deneme2 {

	public static void remoteTwoRedundantChars(String text,Integer repeats ) {
		
		String[] allChars = text.split("");
		int i=0;
		
		Map<String ,Integer> allMap = new HashMap<String ,Integer>();
		
		while(i < allChars.length) {
			
			if( allChars[i].equals(" ")) {
				allMap.put("w" + i, 1);
				continue;
			}
			if(allMap.keySet().contains(allChars[i])){
				Integer currVal =allMap.get(allChars[i]);
				allMap.put(allChars[i], ++currVal);
			}
			else
				allMap.put(allChars[i], 1);
		}
		
		Map<String ,Integer> resMap= allMap.entrySet().stream().filter(a ->a.getValue()>=repeats)
										.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) ->o1 ,LinkedHashMap::new ));
		
		resMap.entrySet().stream().map(item ->item.getKey()).reduce("" ,String::concat);
		
		String currChar ;
		StringBuilder modifiedStr = new StringBuilder();
		String resulStr = modifiedStr.toString();
		
		//Nihai olarak yukarida buldugumuz karakterleri ,string de varsa tutucaz
		for(int j =0 ; j< text.length() ; j++) {
			currChar = text.substring(i ,i+1);
			if(currChar.equals(" ")) currChar = "w" + i;
			
			if(resMap.containsKey(currChar))
				modifiedStr.append(currChar);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String duration ="00:05:01";
		String[] durationArr =duration.split(":");
		
		//Arrays.stream(durationArr).forEach(i -> System.out.println(i));
		Arrays.stream(durationArr).map(i -> { if(i.startsWith("0")) return Integer.parseInt(i.substring(1,2)) ;
											else return Integer.parseInt(i) ;	}).reduce(0, (n,m) -> n *60 + m);
		/*
		map(n -> { if(n.startsWith("0"))
												return n.substring(1,2);  
											 else 
												 return n; ) }) */
	}

}
