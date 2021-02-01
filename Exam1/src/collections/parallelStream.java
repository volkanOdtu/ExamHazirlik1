package collections;

import java.util.Arrays;

public class parallelStream {

	public static void main(String[] args) {
		
		Arrays.asList("a1" ,"a2" ,"b1" ,"c2" ,"c1")
			.parallelStream()
			.filter(item -> {
				System.out.println("Thread Name in filter:" + Thread.currentThread().getName() );
				return true;
			})
			.map(s -> {
				System.out.println("Thread Name in map:" + Thread.currentThread().getName() );				
				return  s.toUpperCase();
			})
			.sorted((o1 ,o2) -> {
				System.out.println("Thread Name in sorted:" + Thread.currentThread().getName() );				
				return o1.compareTo(o2) ;
			})
			.forEach(s ->{
				System.out.println("Thread Name in forEach:" + Thread.currentThread().getName() + s );								
			});
		
		
	}

}
