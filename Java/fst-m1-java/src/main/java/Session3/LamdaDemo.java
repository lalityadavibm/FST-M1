package Session3;

import java.util.Arrays;
import java.util.List;

interface Display{
	String display(String input);
}

public class LamdaDemo {

	public static void main(String[] args) {
		Display test= (String input) -> {
				return input;
			
		};
		System.out.println(test.display("Hello"));
		
		// Function with no name
		// Anonymous fuctions
		
		List<Integer> nums= Arrays.asList(1,2,3,4,5);
	//	nums.forEach(num) -> System.out.println(num);
		


	}

}
