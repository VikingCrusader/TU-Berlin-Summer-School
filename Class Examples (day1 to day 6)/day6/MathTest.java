package day6;

public class MathTest {
    public static void main(String[] args) {
        Calculation obj = new Calculation();

        double res1 = obj.add(2.9, 7.6);
        System.out.println("Addition: " + res1);

        double res2 = obj.mul(2.9, 7.6);
        System.out.println("Multiplication: " + res2);
        
        CalculationNew obj1 = new CalculationNew ();
        double res3 = obj1.division(2.9, 7.6);
        System.out.println("Division: "+ res3);

        Math2 obj5 = new Math2 (24.0,6.0);
    }
}
