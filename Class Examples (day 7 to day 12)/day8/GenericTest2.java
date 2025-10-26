package day8;

public class GenericTest2 {
	public static void main(String[] args) {
		Integer a, b, c;
		a = 5;
		b = 8;
		c = a + b;
		Double x, y, z;
		System.out.println(c);
		x = 9.9;
		y = 7.9;
		z = x * y;
		System.out.println(z);
		add(7,8);
		maximum (9.9, 8.9);
		maximum ("sssss","aa");

	}
	public static <T extends Comparable<T>> void add (T a, T b) {
		Integer c;
		c = (int) a - (int) b;
		System.out.println(c);
	}
	public static <T> void maximum (T a, T b) {
		if (a.equals(b)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");

		}
	}
}
