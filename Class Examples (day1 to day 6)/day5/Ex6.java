package day5;

public class Ex6 {
	public static void main(String[] args) {
		int arr [] = {1, 2, 3, 4, 5};
		double darr [] = {1.23, 3,44, 9,77, 8.97, -5,9};
		String sArr [] = {"Donald","Elon","Barak"};
		printInt(arr);
		System.out.println();
		printDouble(darr);
		System.out.println();
		printString(sArr);

	}
	public static void printInt (int arr[]) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
	public static void printDouble (double arr[]) {
		for (double a : arr) {
			System.out.print(a + " ");
		}
	}
	public static void printString (String sArr[]) {
		for (String a : sArr) {
			System.out.print(a + " ");
		}
	}
}
