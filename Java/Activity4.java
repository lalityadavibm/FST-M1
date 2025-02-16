package Session1;

import java.util.Arrays;

public class Activity4 {
	
	public static void main(String[] args) {
		
		int[] num= {45,1,54,8,0,23,4};
		int temp=0;
		
		System.out.println("Before sorting" + " " + Arrays.toString(num));
		for(int i=0; i<num.length; i++){
			for(int j=i+1;j<num.length;j++) {
				
				if(num[i]>num[j]) {
					temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}

		}
		System.out.print("After sorting" +" "+ Arrays.toString(num));

		
	}

}
