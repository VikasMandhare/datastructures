package trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationSequence {

	private static String getPermutation(int n, int k) {
		int fact[] = new int[n];
		fact[0] = 1;
		for (int i = 1; i < n; i++) {
			fact[i] = i * fact[i - 1];
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++)
			list.add(i);
		String str = "";
		for (int j = n - 1; j >= 0; j--) {
			//This will give you tree tree from 0th level
			int index = k / fact[j];
			System.out.println("k=" + k + ", factorial of " + j + " = " + fact[j] + ", index = " + index);
			//System.out.println("before : " + Arrays.toString(list.toArray()) + ", str =" + str);
			str = str + "" + list.remove(index);
			System.out.println("after : " + Arrays.toString(list.toArray()) + ", str = " + str);
			k = k % fact[j];
		}

		return str;
	}

	public static void main(String[] args) {
		int n = 3, k = 5;
		System.out.println(getPermutation(n, k));

	}

}
