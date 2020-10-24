
public class Problem5SmallestDivisibleNumber {
	private static int smallestDivisibleNumber() {
		int result = 0;

		outer: for (int i = 20 * 20; i < 2147483647; i++) {

			for (int j = 3; j <= 20; j++) {
				if (i % j != 0) {
					continue outer;
				}
			}
			result = i;
			break;

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println("result=" + smallestDivisibleNumber());
	}
}
