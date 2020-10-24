
public class Problem4TwoThreePalindrome {

	private static int largestPalimdrome() {
		int result = 0;

		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				int temp = i * j;
				if (isPalindrome(temp) && temp > result) {
					result = temp;
				}
			}
		}

		return result;

	}

	private static boolean isPalindrome(int num) {
		boolean flag = true;
		String numStr = Integer.toString(num);
		for (int i = 0, j = numStr.length() - 1; i <= j; i++, j--) {
			if (numStr.charAt(i) != numStr.charAt(j)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		System.out.println("result=" + largestPalimdrome());
	}
}
