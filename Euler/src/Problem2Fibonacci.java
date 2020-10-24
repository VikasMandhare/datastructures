
public class Problem2Fibonacci {

	private static int sumEvenFibonacciNums(int range) {
		int sum = 0;
		int x = 1, y = 1;
		int z = 0;
		while (z < range) {
			z = x + y;
			if (z % 2 == 0) {
				sum = sum + z;
			}
			x = y;
			y = z;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumEvenFibonacciNums(4000000));
	}

}
