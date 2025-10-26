package day3;

public class Ex10 {
	public static void main(String[] args) {
		double c, t, t1;
		c = 22;  //square root of 4
		t = c;
		t1 = (t+c/t)/2;
		double error = 1e-15; 
		int i = 0;
		
		while (Math.abs(t1-t) > error) {
			t1 = t;
			t = (t + c/t) / 2;
			i++;
		}	
		System.out.println(t);	
		
		for (int j = 0; Math.abs(t1-t) > error; j++) {
			t1 = t;
			t = (t + c/t) / 2;
		}
		
	}
}
