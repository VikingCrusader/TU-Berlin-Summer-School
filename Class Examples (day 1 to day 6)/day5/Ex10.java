package day5;

public class Ex10 {

	public static void main(String[] args) {
		System.out.println(fib(10));
	}
	
	public static int fib (int n) {
		if (n == 0) n = 0;
		else if (n == 1) n = 1;
		else n = fib(n - 1) + fib (n - 2);
		return n;
	}
}
