package day4;

public class Ex4 {

	public static void main(String[] args) {
		double arr [] = {3.6, 6.9, -10.9, 77, 8.7, -23.8, 0, 5.5, -2.6, 10};
		// insert 55.8 at the loc 0
		double arr1 [] = new double[arr.length + 1];
		arr1 [0] = 55.8;
		for (int i = 1; i < arr.length + 1; i++) {
			arr1[i] = arr[i - 1];
		}
		for (double temp : arr1) {
			System.out.println(temp);
		}
	}
}
