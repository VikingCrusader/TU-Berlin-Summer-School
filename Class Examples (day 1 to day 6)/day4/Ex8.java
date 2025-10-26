package day4;

public class Ex8 {
	public static void main(String[] args) {
		int [][] arr = {{6 , 7, 8},{22 ,-7 ,0},{-4 ,0 ,25},{6 ,9 ,3}};
		for (int i = 0; i < arr.length; i++) { // row loop
			for (int j = 0; j < arr[0].length; j++) { // column loop
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("....");

		for (int [] row : arr) {
			for (int column : row) {
				System.out.println(column);
			}
		}
	}
}
