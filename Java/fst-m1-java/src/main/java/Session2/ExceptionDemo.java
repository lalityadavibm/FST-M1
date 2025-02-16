package Session2;

public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int[] nums= {1,2,3,4};
			System.out.println(nums[8]);
		}finally {
			System.out.println("This will always execute");
		}
		System.out.println("This is after the error");

	}
	public static void throwException() throws Exception{
		int[] nums= {1,2,3,4};
		System.out.println(nums[8]);

	}

}
