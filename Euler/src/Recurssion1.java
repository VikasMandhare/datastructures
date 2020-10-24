
public class Recurssion1 {

	private static int calculate(int num) {
		System.out.println("inside recursion num = " + num);
		if (num == 0) {
			System.out.println("final return");
			return 1;
		} else {
			return 1 + calculate(num - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Main result=" + calculate(10));

	}

}
