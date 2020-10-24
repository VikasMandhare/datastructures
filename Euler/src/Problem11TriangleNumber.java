import java.util.ArrayList;
import java.util.List;

public class Problem11TriangleNumber {

	private static long triangleNumber(long limit) {
		long result = 0;

		boolean found = false;
		long naturalCounter = 1L;
		long tringleCounter = 0L;
		while (found == false) {
			tringleCounter = tringleCounter + naturalCounter;
			if (factorsMatchLimit(tringleCounter, limit)) {
				result = tringleCounter;
				found = true;
				break;
			}
			naturalCounter++;
		}

		return result;
	}

	private static boolean factorsMatchLimit(long num, long limit) {
		List<Long> factors = new ArrayList<>();
		long range = (long) Math.sqrt(num);
		for (long i = 1; i <= range; i++) {
			if (num % i == 0) {
				factors.add(i);
				factors.add(num / i);
			}
		}
		return factors.size() > limit;
	}

	public static void main(String[] args) {
		System.out.println("result=" + triangleNumber(5));
		System.out.println("result=" + triangleNumber(500));
	}

}
