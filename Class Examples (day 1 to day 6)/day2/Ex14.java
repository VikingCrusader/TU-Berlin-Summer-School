package day2;

public class Ex14 {
	public static void main(String[] args) {
		int a, b, c;
		a = 18;
		b = 23;
		c = 108;
		int min = a;
		if (min>=b) {
			min = b;
		}
		if (min>=c) {
			min = c;
		}
		System.out.println(min+" is the minimum number");
	}
}
