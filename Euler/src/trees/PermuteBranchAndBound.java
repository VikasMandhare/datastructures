package trees;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PermuteBranchAndBound {

	private static void branchAndBound(int nums[], List<List<Integer>> result) {
		Queue<List<Integer>> q = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(nums[i]);
			q.offer(list);
		}

		for (int count = 1; count <= nums.length - 1; count++) {
			int runTimes = q.size();
			for (int i = 0; i < runTimes; i++) {
				List<Integer> list = q.poll();
				for (int j = 0; j < nums.length; j++) {
					if (!list.contains(nums[j])) {
						List<Integer> newList = new ArrayList<>(list);
						newList.add(nums[j]);
						q.offer(newList);
					}
				}
			}
		}

		while (!q.isEmpty()) {
			result.add(q.poll());
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> result = new ArrayList<>();
		int nums[] = { 1, 2, 3, 4, 5 };
		branchAndBound(nums, result);

		for (List<Integer> list : result) {
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
