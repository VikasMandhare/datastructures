package trees;

public class SearchValueInTree {

	private int searchNode(TreeNode root, int search) {
		if (null == root) {
			return -1;
		}
		System.out.println("==>" + root.val + " comparing to=" + search);
		if (search == root.val) {
			System.out.println("found");
			return 1;
		} else {
			int found = searchNode(root.left, search);

			if (found != -1) {
				System.out.println("found in left tree");
				return found;
			}
		}
		return searchNode(root.right, search);

	}

	public static void main(String[] args) {

		SearchValueInTree ob = new SearchValueInTree();
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

		System.out.println(ob.searchNode(tree1, 6));
		System.out.println("==============================");
		System.out.println(ob.searchNode(tree2, 2));
		System.out.println("==============================");
		System.out.println(ob.searchNode(tree2, 100));
		System.out.println("==============================");
		System.out.println(ob.searchNode(tree2, 5));

	}

}
