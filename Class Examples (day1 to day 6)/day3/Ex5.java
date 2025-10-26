package day3;

public class Ex5 {
	public static void main(String[] args) {
		// power N of M
		long N, M;
		N = 5; M = 22;
		long r; int i = 0;
		r = 1;
		while (i < M) {
			r = r * N;
			i++;
		}
		System.out.println(r);

	}
}
