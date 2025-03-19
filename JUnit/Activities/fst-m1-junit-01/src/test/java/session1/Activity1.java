package session1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Activity1 {

    // Test fixtures
    static ArrayList<String> list;
    
    @BeforeAll
    static void setUp() {  // Ensure this method is static
        list = new ArrayList<String>();
        list.add("java");
        list.add("python");
    }
    
    @Test
    void insertTest() {
        // Test the initial size of the list
        assertEquals(2, list.size(), "Expected list size to be 2 after initialization");
        
        // Add a new element and check the size again
        list.add("mogali");
        assertEquals(3, list.size(), "Expected list size to be 3 after adding one more element");
        
        // Check if elements are correctly added
        assertTrue(list.contains("java"), "Expected list to contain 'java'");
        assertTrue(list.contains("python"), "Expected list to contain 'python'");
        assertTrue(list.contains("mogali"), "Expected list to contain 'mogali'");
    }
    
    @Test
    void replaceTest() {
        // Test the size of the list before and after adding a new element
        assertEquals(2, list.size(), "Expected list size to be 2 before adding a new element");
        list.add("Radha");
        assertEquals(3, list.size(), "Expected list size to be 3 after adding 'Radha'");
        
        // Replace an element in the list and check the new values
        list.set(1, "Krishna");
        
        // Validate the contents of the list after modification
        assertEquals("java", list.get(0), "Expected element at index 0 to be 'java'");
        assertEquals("Krishna", list.get(1), "Expected element at index 1 to be 'Krishna'");
    }
}
