package day5;

public class StdRandom {
		// Generate an integer between 0 and N - 1
		public static int uniform (int N) {
			return (int)(Math.random() * N);
		}
		// Generate an real number between lo and hi
		public static double uniform (int lo, int hi) {
			return lo + Math.random() * (hi - lo);
		}
		// True with probability p
		public static boolean bernoulli (double p) {
			return Math.random() < p;
		}
		// normal, mean 0, standard deviation 1
		public static double gaussian () {
			double r = Math.random();
			return Math.exp(-r * r / 2) / 2 * Math.PI;
		}
		// normal, mean m, standard deviation s
		public static double gaussian (double mu, double sd) {
			return ( gaussian() - mu ) / sd;
		}
}
