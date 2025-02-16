package Session2;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String>colours=new HashMap<Integer, String>();
		
		colours.put(1, "Red");
		colours.put(2, "Green");
		colours.put(3, "Blue");
		colours.put(4, "White");
		colours.put(5, "Black");
		
       System.out.println("The Original map: " + colours);
        
        colours.remove(4); // Remove one colour
        
        System.out.println("After removing White: " + colours); // Map after removing a colour
        
        // Check if green exists
        if(colours.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        
        // Print the size of the Map
        System.out.println("Number of pairs in the Map is: " + colours.size());
    }

	}

 
