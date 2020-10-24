
public class StringPermutation {

	private static void permute(String permutation, String input) {
		System.out.println("permutation=" + permutation + " input=" + input);
		if (input.length() == 0) {
			System.out.println(permutation + "*************************");
		} else {
			System.out.println("##### starting new for loop #####");
			for (int i = 0; i < input.length(); i++) {
				System.out.println("inside i="+i);
				permute(permutation + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));
			}
		}
	}

	public static void main(String[] args) {
		permute("", "abc");

	}

}
