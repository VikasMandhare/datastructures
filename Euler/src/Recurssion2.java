
public class Recurssion2 {

	private static int calculate(int num, int sum1, int sum2) {
		System.out.println("inside recursion num=" + num + " sum1=" + sum1 + " sum2=" + sum2);
		if (num <= 0) {
			System.out.println("final return************************recurse");
			return 1;
		} else {
			System.out.println("+++++++++++++++++++++++calling first+++++++++++++++++++++++");
			sum1 = calculate(num - 1, sum1, sum2);
			System.out.println("#######################calling second#######################");
			sum2 = calculate(num - 1, sum1, sum2);
			System.out.println("#######################after second####################### || sum2=" + sum2);
		}
		int add = sum1 + sum2;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@return addition@@@@@@@@@@@@@@@@@@@@@@@ || add=" + add);
		return add;
	}

	public static void main(String[] args) {
		System.out.println("Main result=" + calculate(4, 0, 0));

	}

}
