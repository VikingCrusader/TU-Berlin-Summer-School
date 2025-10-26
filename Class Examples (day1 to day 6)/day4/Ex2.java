package day4;

public class Ex2 {
	public static void main(String[] args) {
		double arr [] = {3.6, 6.9, -10.9, 77, 8.7, -23.8, 0, 5.5, -2.6, 10};
		// sum all the elements 
		// print the results;
		double sum = 0;
		for (double a : arr) {
			sum += a;
		}
		System.out.println(sum);
		System.out.println();
		
		//

		
		
		// delete index 4 number of arr
		double arr1 [] = new double[arr.length -1 ];
		for (int i = 0; i < 4 ; i++) {
			arr1 [i] = arr [i];
		}
		for (int i = 4; i < arr.length - 1; i++) {
			arr1 [i] = arr [i + 1];
		}
		for (double temp : arr1) {
			System.out.println(temp);
		}

	}
}
