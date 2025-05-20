package Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
		//caller function
		int sum = add(20,30);
		System.out.println(sum);
		System.out.println(add(sum,100));
		System.out.println(add(40,sum));
		
		int res = add(30,50);
		System.out.println(res);
	}
		// 100 testscript - addition
		public static int add(int a, int b) { //called function - generic - reuseable
		int c = a+b;
		//System.out.println(c);
		return c;

	}
	

}

