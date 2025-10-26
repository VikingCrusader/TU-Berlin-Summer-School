package day4;
import java.util.Scanner;
public class practice_1 {
	//输入一个字符串，判断是否为回文（前后对称）。例如 "level", "madam" 是回文，"hello" 不是。
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
