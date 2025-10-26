package day3;

public class Ex9 {
	public static void main(String[] args) {
	    int N = Integer.parseInt(args[0]);
	    long product = 1;
	    for (int i = 1; i <= N; i++) {
	        product *= i;
	    }
	    System.out.println(N + "! = " + product);
	}
}
