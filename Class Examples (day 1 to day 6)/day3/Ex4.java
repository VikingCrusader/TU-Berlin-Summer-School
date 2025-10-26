package day3;

public class Ex4 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int value = 1;
		int i = 1;
		while (i <= n) {
			value *= 2;
			i++;
		}
		System.out.println(value);
	}
}
