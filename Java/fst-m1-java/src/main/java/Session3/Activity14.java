package Session3;

interface Addable{
	int add(int a, int b);
	
}

public class Activity14 {

	public static void main(String[] args) {
		
		Addable ad1=(a,b) -> a+b;
		System.out.println(ad1.add(45, 90));
		
		Addable ad2=(int a,int b) -> {
			return (a + b);
			
		};
		System.out.println(ad2.add(302,45));
		
		
		

	}

}
