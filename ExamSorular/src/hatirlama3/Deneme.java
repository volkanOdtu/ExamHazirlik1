package hatirlama3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
}
 class Payment {

	private BigDecimal amount;
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Payment(BigDecimal d) {
		this.amount = d;
	}
}

public class Deneme {

	public static List<Student> studentsPassingExam(){
		
		List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        
        List<Student> pasingStudents= students.stream().filter(s -> s.getScore()> 40).
        								sorted( Comparator.comparing(Student::getScore)).collect(Collectors.toList());
        
        pasingStudents.forEach(s -> System.out.println(s.getName() + ":" + s.getScore()));
        return null;

	}
	public static void sum(List<Payment> payments) {
		
		BigDecimal sum = new BigDecimal(0);
		
		sum = payments.stream().map(payment -> payment.getAmount()).reduce(new BigDecimal(0) ,(o1 ,o2) -> o1.add(o2) );
		
		System.out.println(sum.doubleValue());
	}
	
	static int mostPopularNumber(int[] nums) {
		Map<Integer, Integer> resultMap = new LinkedHashMap<Integer, Integer>();
				
		for(int i=0 ; i< nums.length ;i++) {
			if( resultMap.keySet().contains(nums[i]) ) {
				int val = resultMap.get(nums[i]);  
				resultMap.replace(nums[i], ++val);
			}
			else
				resultMap.put(nums[i], 1);
		}
		
		Map<Integer, Integer> newMap =resultMap.entrySet().stream()
										.sorted(Collections.reverseOrder( Map.Entry.comparingByValue()))										
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1 ,o2) ->o1 ,LinkedHashMap::new));
		
		Optional<Map.Entry<Integer ,Integer >> resOptional = resultMap.entrySet().
																stream().max(Map.Entry.comparingByValue());
		
		 int maxVal =0 ;
		if(resOptional.isPresent())
			maxVal = resOptional.get().getValue();
		final int max = maxVal;
		//Eger 1 den coksa en kucugunu alalim
		
		Optional<Map.Entry<Integer,Integer> > resFoundOpt= resultMap.entrySet().stream().
							filter(a -> a.getValue()== max)
							.sorted( Map.Entry.comparingByKey()).
							findFirst();
		int maxKey =0; 
		if(resFoundOpt.isPresent())
			maxKey= resFoundOpt.get().getKey();
		
		System.out.println(maxKey);
		return maxKey;
	}
	public static void solution(int sayi) {
		
		int min =0 ,max =sayi;
		
		while(min <= sayi) {
			staircase(max--, min++);
		}
		
	}
	public static void staircase(int n ,int m) {
		for(int i=n ; i> 0; i--) {
			System.out.print(" ");
		}
			
		for(int i=0 ; i< m; i++)
			System.out.print("#");
		
		System.out.println();
	}
	
	static void printGraph(int whiteSpaceCount ,int symbolCount) {
		if(whiteSpaceCount == -1) return;
		
        for(int i=0 ;i <whiteSpaceCount ; i++)
            System.out.print(" ");
        
        for(int i=0 ;i <symbolCount ; i++)
            System.out.print("#");
        
        System.out.println();

        printGraph(whiteSpaceCount--, ++symbolCount);
	}
	public static void main(String[] args) {
		
		int[] nums = { 34, 31, 34, 77, 82};
		
		//mostPopularNumber(nums);
		solution(4);
		/*
		staircase(4 ,0);
		staircase(3 ,1);
		staircase(2 ,2);
		staircase(1 ,3);
		staircase(0 ,4);
		
		/*
		int[] amounts = { 2000 ,500 ,200 ,100 ,50 ,20 ,10 ,5 ,1};
		int[] banknotesCount = new int[9];

		for(int i =0; i< amounts.length ;i++) {
			if(amount / amounts[i] ) {
				banknotesCount[i] = amount / am
			}
		}
		/*
		List<Payment> payments = new ArrayList<Payment>();
		Payment p1 = new Payment(new BigDecimal(10));
		Payment p2 = new Payment(new BigDecimal(20));
		payments.add(p1);
		payments.add(p2);
		
		sum(payments);
		
		 //studentsPassingExam();
		/*
		String[][] allServers = new String[3][2];
		
		
		 
		allServers[0][1] = "01";
		allServers[0][0] = "00";
		 
		allServers[1][1] = "11";
		allServers[1][0] = "10";
		 
		allServers[2][1] = "21";
		allServers[2][0] = "20";
		
		
		for(int x=2 ; x>= 0 ; x-- ) {
			for(int y=1 ; y>=0 ;y--) {
				System.out.println(allServers[x][y] ); 
			}
		}
		 */
	}

}
