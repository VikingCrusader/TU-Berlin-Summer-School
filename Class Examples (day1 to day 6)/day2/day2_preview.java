package day2;
import java.util.Scanner;

public class day2_preview {
	static int age = 25;
	static double height = 1.75;
	static char grade = 'A';
	static boolean isStudent = true;
	static int score = 85;
	static int number = -10;
	static int day = 3;
	public static void main(String[] args) {
		System.out.println("Age: "+age+" Height:"+height+" Grade:"+grade+" isStudent:"+isStudent+"");
	
		if(score >= 90) {
			System.out.println("A");

		}else if(score >= 80 && score <= 89) {
			System.out.println("B");

		}else if(score >= 70 && score <= 79) {
			System.out.println("C");

		}else {
			System.out.println("Fail!");

		}
		
		if(number > 0) {
			if(number % 2 == 0) {
				System.out.println("Positive Even");
			}else {
				System.out.println("Positive Odd");

			}
		}else {
			System.out.println("Negative Number");

		}
		
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			break;
		}
		
		Scanner input = new Scanner(System.in);  //First, create a scanner object
		System.out.print("Please enter your name: ");
		String name = input.nextLine(); //Reading a whole line string
		System.out.print("Please enter your age: ");
		int age = input.nextInt(); //Read a integer
		System.out.print("Please enter your height: ");
		double height = input.nextDouble();
		System.out.println("你好，" + name + "，你今年" + age + "岁，身高" + height + "米");
		
		
		System.out.print("Please enter your grade: ");
		int grade1 = input.nextInt();
		if (grade1 >= 90) {
			System.out.println("Excellent");
		}
		input.close(); //close Scanner finally

	}
	
	
}

