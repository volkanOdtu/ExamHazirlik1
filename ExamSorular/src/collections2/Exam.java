package collections2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Exam e = new Exam();
	  ArrayList<Integer> movieDuration = new ArrayList();
	  
	  //movieDuration.add(1); movieDuration.add(10); movieDuration.add(25); movieDuration.add(35); movieDuration.add(60);	  	  
	  //PairInt res= e.IDsOfMovies(90, 5, movieDuration);
	  
	  //movieDuration.add(20); movieDuration.add(70); movieDuration.add(90); movieDuration.add(30); movieDuration.add(60);movieDuration.add(110);
	  //PairInt res= e.IDsOfMovies(110, 6, movieDuration);
	  
	  movieDuration.add(100); movieDuration.add(180); movieDuration.add(40); movieDuration.add(120); movieDuration.add(10);
	  PairInt res= e.IDsOfMovies(250, 5, movieDuration);

	}
	PairInt IDsOfMovies(int flightDuration ,int numMovies ,ArrayList<Integer> movieDuration) {
		PairInt emptyResult = new PairInt(-1, -1);
		
		int desiredEndingTime = flightDuration -30;
		
		Integer[] moviesArr = new Integer[movieDuration.size()]; 
		moviesArr = movieDuration.toArray(moviesArr); 
        
		
		Map<String, Integer> resultListPairsMap  = new LinkedHashMap<>();
		
				
		for( int i =0 ; i< moviesArr.length ; i++) {

			for( int j =0 ; j< moviesArr.length; j++) {
				if(i ==j) continue; //same movies wont be added
				
				if(moviesArr[i] + moviesArr[j] ==desiredEndingTime )
				{
					if(resultListPairsMap.containsKey(i + "_" +j)) continue;

					if(resultListPairsMap.containsKey(j + "_" + i)) continue;
					
					int max =moviesArr[i] ;
					if( moviesArr[j] > max ) max = moviesArr[j] ;
					
					resultListPairsMap.put( i +"_" +j , max);
				}
				
				
			}
		}

		//lets select the pair with the longest
		
		Optional<Entry<String ,Integer>> itemWithMaxValue = resultListPairsMap.entrySet().stream().max(Map.Entry.comparingByValue());
		
			
		
		if(resultListPairsMap == null || resultListPairsMap.size() == 0)		
			return emptyResult;
		else {
			
				if(itemWithMaxValue.isPresent()) {
					String[] key= itemWithMaxValue.get().getKey().split("_");
					
					return new PairInt( Integer.parseInt(key[0] ) , Integer.parseInt(key[1] ) );
					
				}else
					return emptyResult;		
					
		}
			
	}

	
	class PairInt{
		int first ,second;
		
		PairInt(){}
		
		public PairInt(int first ,int second) {
			this.first = first;
			this.second = second;
		}
	}
	}
