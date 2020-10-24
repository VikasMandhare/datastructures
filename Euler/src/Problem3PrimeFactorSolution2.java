import java.util.ArrayList;
import java.util.List;

public class Problem3PrimeFactorSolution2 {

	private static long largestPrimeFactor(long num) {
		long largeFactor = 0;
		List<Long> factors = getFactors(num);

		for (Long factor : factors) {
			if (isPrime(factor)) {
				largeFactor = factor;
			}
		}

		return largeFactor;
	}

	private static boolean isPrime(Long num) {
		return getFactors(num).size() == 2;
	}

	private static List<Long> getFactors(Long num) {
		List<Long> factors = new ArrayList<>();

		for (Long i = 1L; i <= Math.sqrt(num) + 1; i++) {
			if (num % i == 0) {
				factors.add(i);       //factor
				factors.add(num / i); //number divided by factor for finding pair
			}
		}

		return factors;
	}

	public static void main(String[] args) {
		System.out.println("result=" + largestPrimeFactor(30L));
		System.out.println("result=" + largestPrimeFactor(13195L));
		System.out.println("result=" + largestPrimeFactor(600851475143L));
	}

}
