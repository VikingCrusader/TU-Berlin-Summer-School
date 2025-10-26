package day5;

public class Ex7 {
	public static void main(String[] args) {
		int arr [] = {1, 3, 5, 7, 9, 11};
		int arr1 [] = doubleArray(arr);
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println();
		Ex6.printInt(arr1);
		System.out.println();
		Ex6.printInt(arr1);
	}
	public static int[] doubleArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
		}
		return arr;
	}
}
