package Session2;

import java.util.HashSet;

public class Activity10 {
	
	public static void main(String[] args) {
		
		HashSet<String>hs=new HashSet<String>();
		
		hs.add("one");
		hs.add("two");
		hs.add("three");
		hs.add("four");
		hs.add("five");
		hs.add("six");
		
		System.out.println("Size of hashset: " + hs.size());
		
		hs.remove("two");
		
		   if(hs.remove("nine")) {
	        	System.out.println("nine removed from the Set");
	        } else {
	        	System.out.println("nine is not present in the Set");
	        }
				
		hs.contains("six");
		
		System.out.println("Updated hashset: " + hs);
		
	}

}
