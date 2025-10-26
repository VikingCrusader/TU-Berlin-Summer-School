package day4;

public class Ex1 {
	public static void main(String[] args) {
		int a1 = 10;
		int a2 = 23;
		int a3 = -16;
		int a4 = 6;
		int a5 = 7;
		// hard to deal with, because ai is not an index
		
		int a [] = {10, 23, -16, 6, 7};
		for (int i : a) {
			System.out.println(i);
		}
		
		//create empty array
		double [] arr = new double[10];
		System.out.println(arr);

		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);  // all elements will be zero

		}
		
		String str [] = new String [10];
		str [7] = "";
		str [8] = " ";
		str [9] = "null";
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		for (String temp : str) {
			System.out.println(temp);
		}
		
		
		
		
	}
}
