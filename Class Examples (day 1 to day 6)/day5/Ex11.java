package day5;

// 汉诺塔问题
public class Ex11 {
	public static void main(String[] args) {
		int n = 4;
		moves (n, true);
	}
	public static void moves (int n, boolean left) {
		if (n == 0) return;
		moves (n - 1, !left);
		if (left) {
			System.out.println(n + " move to Left");
		} else {
			System.out.println(n + " move to right");
		}
		moves (n-1, !left);
	}
}
