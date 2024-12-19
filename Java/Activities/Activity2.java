package Java02;

public class Activity2 {

	public static void main(String[] args) {
		
		int [] number= {10, 77, 10, 54, -11, 10};
		int sum=0;
		
		for(int num:number) {
			
			if(num==10) {
				sum+=num;
			}
		}
		System.out.println(sum);

	}

}
