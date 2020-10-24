import java.util.Arrays;

//https://drive.google.com/file/d/1upjiOWM20ytxrxuqoaZNsYX_pF9sFUsG/view
//https://www.youtube.com/watch?v=7IQHYbmuoVU
public class CombinationsOfStringsInArray {
	static int count = 0;

	public static void main(String[] args) {
//		String[] words = { "a", "b", "c", "d" };
		String[] words = { "a", "b", "c", "c", "c", "c", "c", "c" };
		count = 0; // counter to count the number of words formed
		permute(words, 0);
	}

	static void permute(String[] s, int i) {
		// System.out.println("\n\n################################################");
		// System.out.println("**************inside permute i=" + i + " array value=" +
		// Arrays.toString(s));
		if (i == s.length - 1) {
			count++; // count no of words output and print the permutation.
			System.out.println(count + ") " + Arrays.toString(s));
			return;
		}
		int curr = i;
		for (; i < s.length; i++) {

			if (i != curr) {
				swap(s, i, curr);
//				System.out.println("swapped :: i= " + i + " curr=" + curr + " array value=" + Arrays.toString(s));

			}

	//		System.out.println("********permutation called :: i= " + i + " curr=" + (curr + 1) + " array value="
		//			+ Arrays.toString(s));
			permute(s, curr + 1);

			if (i != curr) {
				swap(s, i, curr);
			//	System.out.println(
				//		"reverting swapped :: i= " + i + " curr=" + curr + " array value=" + Arrays.toString(s));

			}
		}
	}

	static void swap(String[] s, int i, int j) {
		String c = s[i];
		s[i] = s[j];
		s[j] = c;
	}
}
