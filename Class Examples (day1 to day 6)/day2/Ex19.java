package day2;

public class Ex19 {
	public static void main(String[] args) {
		int temp;
		int humid;
		temp = Integer.parseInt(args[0]);
		humid = Integer.parseInt(args[1]);
		
		if (temp >= 35) {
			if (humid >= 55) {
				System.out.println("The weather is too hot");

			}else {
				System.out.println("The weather is hot");

			}
		}
		
		if (temp >= 20 && temp < 35) {
			if (humid >= 55) {
				System.out.println("Normal summer weather");

			}else {
				System.out.println("Nice summer weather");

			}
		}
		
		if (temp >= 2 && temp < 20) {
			System.out.println("Nice Winter Weather");
		}
		
		if (temp < 2) {
			System.out.println("Very cold weather");

		}
	}
}
