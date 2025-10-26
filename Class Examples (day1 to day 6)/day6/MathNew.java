package day6;

public class MathNew extends Mathhhh{
		private double a;
		private double b;
		
		
		public double getA() {
			return a;
		}

		public void setA(double a) {
			this.a = a;
		}

		public double getB() {
			return b;
		}

		public void setB(double b) {
			this.b = b;
		}

		public MathNew(double a, double b) {
			super(a, b);
			a = a;
			b = b;
		}
		
		double div () {
			return this.a / this.b;
		}
		
		double sub () {
			return this.a - this.b;
		}
		
		
		
}
