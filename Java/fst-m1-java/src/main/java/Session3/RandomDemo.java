package Session3;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand=new Random();
		System.out.println(rand.nextInt(10, 20));

	}
	
	public Integer getRandomMultipleOf2(Random rand) {
		
		int randVal = rand.nextInt();
		while(randVal % 2 !=0) {
			randVal= rand.nextInt();
		}
		return randVal;
		
	}

}
