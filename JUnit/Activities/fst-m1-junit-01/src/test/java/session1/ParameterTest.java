package session1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterTest {
	
	@ParameterizedTest
	@ValueSource(ints = {2,4,6,8})
	void testWithValues(int value) {
		int remainder = value % 2;
		assertEquals(0, remainder);
	}
	
	




}
