package day2;
import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) {
		int year;
		System.out.println("Which year?");
		Scanner input = new Scanner(System.in);
		year = input.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(year+" is a leap year");
		}else {
			System.out.println(year+" is not a leap year");

		}
		
		boolean isLeap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
		String str = (isLeap == true) ? ("Is a leap year") : ("Not a leap year");
		System.out.println(str);
	}

}
