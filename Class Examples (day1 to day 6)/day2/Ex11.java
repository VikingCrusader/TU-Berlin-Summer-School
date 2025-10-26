package day2;

public class Ex11 {
	public static void main(String[] args) {
		double a, b, c;
		a = 12.8;
		b = 13.7;
		c = -12.9;

		boolean t1 = (a >= b) & (a >= c);
		boolean t2 = (b >= a) & (b >= c);
		boolean t3 = (c >= a) & (c >= b);

		String str = t1 ? "A is the maximum" :
		             t2 ? "B is the maximum" :
		             t3 ? "C is the maximum" :
		             "All values are equal";

		System.out.println(str);
	}
}
