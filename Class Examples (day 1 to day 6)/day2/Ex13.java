package day2;

public class Ex13 {
	public static void main(String[] args) {
		double a, b, c;
		a = 12.8;
		b = 13.7;
		c = -12.9;
		double minimum = -9999999999999.0;
		minimum = a;
		if (b<minimum) {
			minimum = b;
		}
		if (c<minimum) {
			minimum = c;
		}
		System.out.println(minimum);

	}
}