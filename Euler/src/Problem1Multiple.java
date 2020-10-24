
public class Problem1Multiple {

	public static int sumOfAllMultiples(int range) {
		//https://github.com/geraldatanga44/Project-Euler-Java-Solutions
		int sum = 0;

		for (int i = 1; i < range; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum = sum + i;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sumOfAllMultiples(1000));
		System.out.println('A' - 'A'+1);
		 
	}
}

