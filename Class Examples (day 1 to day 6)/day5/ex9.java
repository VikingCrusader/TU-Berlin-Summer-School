package day5;

public class ex9 {
	public static void main(String[] args) {
		System.out.println(power (5,2));

	}
	public static long power(long n, long m) {
			if (m == 0) {
				return 1;
			} else {
				return n * power (n, m - 1);
			}
	}
}
