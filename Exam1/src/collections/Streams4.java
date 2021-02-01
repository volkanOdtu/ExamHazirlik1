package collections;

import java.util.stream.Stream;

public class Streams4 {
	public static void main(String[] args) {
		
		Stream.generate(Math::random)
			.limit(5)
			.forEach(i -> System.out.println(i));
		
	}
}
