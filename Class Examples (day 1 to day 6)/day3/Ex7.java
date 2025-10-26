package day3;

public class Ex7 {
	public static void main(String[] args) {
		double c, t, t1;
		c = 2298989;  //square root of 4
		t = c;
		t1 = c;
		double error = 1e-15; 
		int i = 0;
		
		while (i<=100) {
			t1 = t;
			t = (t + c/t) / 2;
			i++;
		}	
		System.out.println(t);	
	}
}
