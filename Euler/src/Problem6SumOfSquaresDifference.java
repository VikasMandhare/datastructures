
public class Problem6SumOfSquaresDifference {
	private static long difference() {
		long result = 0;

		long sum = 0;
		long sumOfSquares = 0;
		for (long i = 1; i <= 100; i++) {
			sum = sum + i;
			sumOfSquares = sumOfSquares + (i * i);
		}

		result = (sum * sum) - sumOfSquares;

		return result;
	}

	public static void main(String[] args) {
		System.out.println("result=" + difference());
	}
}
