package trees;

public class DepestNodeOfTree {

	private int getDeepestNode(TreeNode root) {
		if (null == root) {
			System.out.println("last node found");
			return -1;
		}
		if (null != root && null != root.left)
			return getDeepestNode(root.left);

		if (null != root && null != root.right)
			return getDeepestNode(root.right);

		return root.val;
	}

	public static void main(String[] args) {

		DepestNodeOfTree ob = new DepestNodeOfTree();
		TreeNode tree1 = new TreeNode(5);
		tree1.left = new TreeNode(3);
		tree1.left.left = new TreeNode(2);
		tree1.left.left.left = new TreeNode(1);
		tree1.left.left.left.right = new TreeNode(25);
		tree1.right = new TreeNode(7);
		tree1.right.left = new TreeNode(6);

		TreeNode tree2 = new TreeNode(3);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(6);
		tree2.right.left = new TreeNode(5);
		tree2.right.right = new TreeNode(7);
		tree2.right.left.left = new TreeNode(4);
		tree2.right.left.left.left = new TreeNode(2);
		tree2.right.left.left.left.left = new TreeNode(1);

		System.out.println(ob.getDeepestNode(tree1));
		System.out.println(ob.getDeepestNode(tree2));

	}

}
