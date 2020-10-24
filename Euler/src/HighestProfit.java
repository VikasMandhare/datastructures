import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HighestProfit {

	public int getProfit(int numSuppliers, int[] inventory, int order) {
		int profit = 0;

		List<Stack<Integer>> iCart = new ArrayList<>();

		// fill iCart
		int max = 0;
		for (int i = 0; i < numSuppliers; i++) {

			Stack<Integer> q = new Stack<>();
			if (inventory[i] > max) {
				max = inventory[i];
			}
			for (int j = 1; j <= inventory[i]; j++) {
				System.out.println("Making queue entries ----" + j);
				q.add(j);
			}
			iCart.add(q);
		}

		outer: for (int k = 0; k < order && max > 0;) {
			for (int i = 0; i < numSuppliers && k < order; i++) {
				if (iCart.get(i).size() >= max) {
					int sold = iCart.get(i).pop();
					System.out.println("Sold=" + sold);
					profit = profit + sold;
					k++;
				}
			}
			max--;
		}

		return profit;
	}

	public static void main(String[] args) {
		HighestProfit ob = new HighestProfit();
		int[] inventory = { 3, 5 };

		System.out.println("Total profit = " + ob.getProfit(2, inventory, 6));
		System.out.println("======================================================");
		int[] inventory1 = { 2, 8, 4, 10, 6 };
		System.out.println("Total profit = " + ob.getProfit(5, inventory1, 20));
	}

}
