package Session2;


 class CustomException extends Exception {
	
	private String message;
	
	public CustomException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}


public class Activity8 {

	public static void exceptionTest(String str) throws CustomException {
		if(str==null) {
			throw new CustomException("String value is null");
			
		}else {
			System.out.println(str);
		}

	}
	public static void main(String[] args) {
		
			
		
		try {

			Activity8.exceptionTest("Able to print in the consol");
			Activity8.exceptionTest(null);
			Activity8.exceptionTest("unable to exceute");
			
		}catch (CustomException e) {
			System.out.println("Inside catch block: " + e.getMessage());
			
		}
		
			
		}

	}
	


