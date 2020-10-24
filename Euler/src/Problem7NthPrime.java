import java.util.ArrayList;
import java.util.List;

public class Problem7NthPrime {
	private static long nthPrime(int position) {
		int result = 0;
		int counter = 1;
		for (int x = 2; counter <= position; x++) {
			if (isPrime(x) && x > result) {
				counter++;
				result = x;				
			}
		}
		System.out.println(position);

		return result;
	}

	private static boolean isPrime(int num) {
		return getFactors(num).size() == 2;
	}

	private static List<Integer> getFactors(int num) {
		List<Integer> factors = new ArrayList<>();

		for (int i = 1; i <= Math.sqrt(num) ; i++) {
			if (num % i == 0) {
				factors.add(i); // factor
				factors.add(num / i); // number divided by factor for finding pair
			}
		}

		return factors;
	}

	public static void main(String[] args) {
		//System.out.println("result=" + nthPrime(6));
		 System.out.println("result=" + nthPrime(10001));
	}
}
