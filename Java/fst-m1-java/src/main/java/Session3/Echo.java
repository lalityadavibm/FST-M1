package Session3;

public class Echo<T> { // T is data type of set
	private T data;
		
	public Echo(T data) {
		this.data=data;
		
	}
	public T getData() {
		return this.data;
	}
	

	public static void main(String[] args) {

		Echo e1 =new Echo<String>("Hello");
		Echo e2 =new Echo<Integer>(5);
		Echo<Boolean> e3=new Echo<Boolean>(true);
		
		System.out.println(e1.getData());
		System.out.println(e2.getData());
		System.out.println(e3.getData());
		

	}

}
