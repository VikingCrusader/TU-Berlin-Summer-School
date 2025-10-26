package day9;

public class CalculationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculation obj1 = new Calculation (2.6, 4.8);
		double expected = obj1.add();
		double actual = 7.4;
		if (expected == actual) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Wrong");
		}
	}
	

}
