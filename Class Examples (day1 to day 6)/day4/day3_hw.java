package day4;
import java.util.Scanner;

public class day3_hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please tell a integer: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        int reversed = 0;
        
        System.out.println("Using loop or string?");
        String answer = scanner.nextLine();
        if (answer.equals("loop")) {
        	while(number != 0) {
            	int digit = number % 10;
            	reversed = reversed * 10 + digit;  
            	number /= 10;
            }
        }
        if (answer.equals("string")) {
        	String str = Integer.toString(number);
        	String str1 = new StringBuilder(str).reverse().toString();
        	reversed = Integer.parseInt(str1);
        }
        
       
        
        System.out.println("The reversed result is: " + reversed);
    }
}
