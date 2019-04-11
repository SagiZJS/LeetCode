package easy;

public class _112_Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return DFSSum(root, sum, 0);
	}

	public boolean DFSSum(TreeNode root, int sum, int thisSum) {
		int nextSum = thisSum + root.val;
		if (nextSum == sum) {
			if (root.left == null && root.right == null) {
				return true;
			}
		}
		if (root.left != null) {
			if (DFSSum(root.left, sum, nextSum)) {
				return true;
			}
		}
		if (root.right != null) {
			return DFSSum(root.right, sum, nextSum);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
