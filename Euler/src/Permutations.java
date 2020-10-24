import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static int numTrees(int n) {
		int comb=0;
		Integer[] num = new Integer[n];
		for (int i = 1; i <= n; i++) {
			num[i - 1] = i;
		}

		List<Integer[]> pemutations = new ArrayList<>();
		pemutations = permute(num, 0, n - 1, pemutations);
        for(Integer[] arr:pemutations){            
            	if(isInorder(arr,arr.length)) {
            		comb++;
            	}
        }
		return comb;

	}
	
	static boolean isInorder(Integer[] arr, int n) { 
        // Array has one or no element  
        if (n == 0 || n == 1) { 
            return true; 
        } 
  
        for (int i = 1; i < n; i++) // Unsorted pair found  
        { 
            if (arr[i - 1] > arr[i]) { 
                return false; 
            } 
        } 
  
        // No unsorted pair found  
        return true; 
    } 

	private static List<Integer[]> permute(Integer[] num, int left, int right, List<Integer[]> pemutations) {
		if (left == right) {
			pemutations.add(num);
			return pemutations;
		}
		int replaceIndex = left;
		for (int x = left; x <= right; x++) {
			Integer[] swapped = swap(num, replaceIndex, x);
			permute(swapped, replaceIndex + 1, right, pemutations);
		}
		return pemutations;
	}

	private static Integer[] swap(Integer[] num, int x, int y) {
		Integer[] temp = new Integer[num.length];
		for (int j = 0; j < num.length; j++) {
			temp[j] = num[j];
		}
		Integer z = temp[y];
		temp[y] = temp[x];
		temp[x] = z;
		return temp;
	}

	public static void main(String[] args) {
		System.out.println("Final result: "+numTrees(3));
	}

}
