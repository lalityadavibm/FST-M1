package session1;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Activity1 {

	// Test fixtures
	static ArrayList<String> list;
	
	@BeforeAll
	void setUp() {
		list= new ArrayList<String>();
		list.add("java");
		list.add("python");
	}
	
	@Test
	void insertTest() {
		assertEquals(2, list.size(), "Wrong size");
		
		list.add("mogali");
		assertEquals(3, list.size(), "Wrong Element");
		
		assertTrue(list.contains("java"));
		assertTrue(list.contains("python"));
		assertTrue(list.contains("mogali"));
	}
	
	@Test
	void replaceTest() {
		
		assertEquals(2, list.size(), "wrong size");
		list.add("Radha");
		assertEquals(3, list.size(), "Wrong Element");
		
		list.set(1, "Krishna");
		
		assertEquals("java", list.get(0), "Wrong element");
		assertEquals("Krishna", list.get(1), "Wrong Element");
		
		
	}
}
