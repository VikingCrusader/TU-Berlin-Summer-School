package day4;

public class week1_exe {
	public static void main(String[] args) {
		//写一个方法，输入一个字符串，返回其中元音（a, e, i, o, u）的个数（不区分大小写）。
		String input = "Hello Java Developer";
		input = input.toLowerCase();
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'a' | input.charAt(i) == 'e' | input.charAt(i) == 'i' | input.charAt(i) == 'o' | input.charAt(i) == 'u') {
				sum ++;
			}
		}
		System.out.println(sum);

	}
}
