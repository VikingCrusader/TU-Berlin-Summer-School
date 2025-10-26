package day3;

public class Ex6 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int value = 1;
		while (true) {
			if (value *2 <= N) {
				value = value * 2;
			}else {
				break;
			}
		}
		System.out.println(value);

	}
}
