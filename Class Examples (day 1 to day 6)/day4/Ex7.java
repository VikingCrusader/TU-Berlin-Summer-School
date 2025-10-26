package day4;

public class Ex7 {
	public static void main(String[] args) {
		int [][] arr = new int [3][4]; // 3 columns, 4 rows
		arr [2][2] = 7;
		arr [2][0] = 9;
		
		for (int i = 0; i < 4; i++) { // row loop
			for (int j = 0; j < 3; j++) { // column loop
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();

		}
	}
}
