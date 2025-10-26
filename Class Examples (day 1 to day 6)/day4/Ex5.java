package day4;

import java.util.Iterator;

public class Ex5 {
	public static void main(String[] args) {
		//reverse array
		double arr [] = {3.6, 6.9, -10.9, 77, 8.7, -23.8, 0, 5.5, -2.6, 10};
		for (int i = 0; i < arr.length / 2; i++) {
			double t = arr [i];
			arr [i] = arr [arr.length - 1 - i];
			arr [arr.length - 1 - i] = t;
		}
		for (double temp : arr) {
			System.out.println(temp);
		}
	}
}
