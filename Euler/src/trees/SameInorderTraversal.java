package trees;

import java.util.List;
import java.util.ArrayList;

public class SameInorderTraversal {

	private void inOrder(TreeNode root, List<Integer> list) {
		if (null == root)
			return;
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);

	}

	public static void main(String[] args) {

		SameInorderTraversal ob = new SameInorderTraversal();

		TreeNode tree1 = new TreeNode(5);
		tree1.left = new TreeNode(3);
		tree1.left.left = new TreeNode(1);
		tree1.right = new TreeNode(7);
		tree1.right.left = new TreeNode(6);

		TreeNode tree2 = new TreeNode(3);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(6);
		tree2.right.left = new TreeNode(5);
		tree2.right.right = new TreeNode(7);

		List<Integer> list1 = new ArrayList<>();
		ob.inOrder(tree1, list1);

		List<Integer> list2 = new ArrayList<>();
		ob.inOrder(tree2, list2);

		System.out.println("Same ? " + list1.equals(list2));
	}

}
