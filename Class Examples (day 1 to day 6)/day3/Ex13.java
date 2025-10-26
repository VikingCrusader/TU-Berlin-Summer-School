package day3;

public class Ex13 {
	public static void main(String[] args) {
		int x = 20;
		int a = 0;
		int b = 1;
		int sum = 0;
		System.out.print(a + " " + b + " ");

		for (int i = 0; i < x; i++) {
			sum += a;
			a = b;
			b = a + b;
			System.out.print(a+" ");

		}

	}
}

// 0 1 1 2 3 5 8 13 21...