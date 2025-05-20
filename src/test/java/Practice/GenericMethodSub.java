package Practice;

public class GenericMethodSub {

	public static void main(String[] args) {
		int minus = sub(50,30);
		System.out.println(minus);
		System.out.println(sub(minus,10));
	}
	
	public static int sub(int a, int b) {
		int c = a - b;
		return c;
	}

}