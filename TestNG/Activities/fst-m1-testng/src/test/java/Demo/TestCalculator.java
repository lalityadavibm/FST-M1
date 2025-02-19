package Demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCalculator {

	private Calculator calculator;
	
	@BeforeClass
	public void setup()
	{
		calculator =new Calculator();
		
	}
	@Test
	public void test() {
		
		System.out.println("Testing");
		
	}

}
