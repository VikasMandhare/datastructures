package trees;

public class DepthOfTree {

	private int getDepth(TreeNode root) {
		if (null != root && null == root.left && null == root.right)
			return 1;
		int leftd = 0;
		if (root.left != null)
			leftd = getDepth(root.left) + 1;
		int rightd = 0;
		if (root.right != null)
			rightd = getDepth(root.right) + 1;
		return Math.max(leftd, rightd);
	}
	
	private int getDepthOptimized(TreeNode root) {
		if (null == root) return 0;
		int leftd = 0;
		if (root.left != null)
			leftd = getDepth(root.left) + 1;
		int rightd = 0;
		if (root.right != null)
			rightd = getDepth(root.right) + 1;
		return Math.max(leftd, rightd);
	}

	public static void main(String[] args) {

		DepthOfTree ob = new DepthOfTree();
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
		tree2.right.left.left = new TreeNode(4);
		tree2.right.left.left.left = new TreeNode(2);
		tree2.right.left.left.left.left = new TreeNode(1);

		System.out.println(ob.getDepth(tree1));
		System.out.println(ob.getDepth(tree2));
		System.out.println("=============================");
		System.out.println(ob.getDepthOptimized(tree1));
		System.out.println(ob.getDepthOptimized(tree2));

	}

}
