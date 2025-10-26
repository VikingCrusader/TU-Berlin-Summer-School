package day2;

public class Ex3 {
	public static void main(String[] args) {
		double a, b, c;
		a = 60;
		b = 7;
		
		c = a / b;
		System.out.println(c);
		c = (double) 60 / 7;
		System.out.println(c);
		c = 60 / 7;
		System.out.println(c);
		//整数除以整数，即使得出的数据类型是double，也会去掉小数部分
		
		int a1, b1;
		a1 = 60;
		b1 = 7;
		double d=a1/b1;
		System.out.println(d);
		
		
		// bitwise calculate
		int x, y, z;
		x = 11 & 9;
		y = x ^ 3;
		z = y | 12;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}

}
