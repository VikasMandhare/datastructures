import java.util.ArrayList;
import java.util.List;

public class Problem10SumOfPrimes {

	private static long sumOfPrimes(int limit) {
		long result = 2L;

		for (long i = 3; i < limit; i = i + 2) {
			if (isPrime(i)) {
				result = result + i;
			}
		}
		return result;
	}

	private static boolean isPrime(long num) {
		List<Long> factors = new ArrayList<>();
		long range = (long) Math.sqrt(num);
		for (long i = 1; i <= range; i++) {
			if (num % i == 0) {
				factors.add(i);
				factors.add(num / i);
			}
		}
		return factors.size() == 2;
	}

	public static void main(String[] args) {
		System.out.println("result=" + sumOfPrimes(10));
		System.out.println("result=" + sumOfPrimes(2000000));
	}
}
