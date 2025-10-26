package day2;

public class Ex6 {
	public static void main(String[] args) {
		int a, b, c;
		double x, y, z;
		
		a = 8;
		
		System.out.println(a);
		
		x = a;
		
		System.out.println(x);
		
		y = 18.9;
		a = (int)y;
		System.out.println(y);
		System.out.println(a);
		
		String s = "12";
		String s1 = s + a;
		System.out.println(s1);
		
		b = Integer.parseInt(s1);
		c = b + a;
		System.out.println(c);

	}
}
