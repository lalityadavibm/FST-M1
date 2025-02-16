package Session2;

import java.util.ArrayList;

public class Activity9 {
	
	public static void main(String[] args) {
		
		ArrayList<String> myList=new ArrayList<String>();
		
		myList.add("Lalit");
		myList.add("yadav");
		myList.add("Software");
		myList.add(1, "Testing");
		myList.add(2, "automation");
		
		System.out.println("print all object: ");
		for(String s:myList) {
			System.out.println(s);
		}
		
		 System.out.println("3rd element in the list is: " + myList.get(2));
	        System.out.println("Is Chicku is in list: " + myList.contains("yadav"));
	        System.out.println("Size of ArrayList: " + myList.size());
	        
	        myList.remove("Software");
	        
	        System.out.println("New Size of ArrayList: " + myList.size());
		
	}

}
