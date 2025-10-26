package day4;

public class Ex3 {
	public static void main(String[] args) {
		double arr [] = {3.6, 6.9, -10.9, 77, 8.7, -23.8, 0, 5.5, -2.6, 10};
		double max = Double.NEGATIVE_INFINITY;
		for (double temp : arr) {
			if (max < temp) {
				max = temp;
			}
		}
		System.out.println(max);
	}
}
