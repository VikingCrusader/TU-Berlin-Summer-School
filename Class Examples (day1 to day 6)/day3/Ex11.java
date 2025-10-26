package day3;

public class Ex11 {	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double value;
		for (int i = 0; i < N; i++) {
			value = 2 * Math.PI * i / N;
			System.out.println(value);

		}

	}
}
