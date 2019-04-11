package easy;

public class _110_Balanced_Binary_Tree {
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		return height(root)==-1?false:true;
	}
	public int height(TreeNode root) {
		int rheight = 0,lheight=0;
		if(root.left!=null) {
			lheight = height(root.left)+1>0?height(root.left)+1:-1;
		}
		if(root.right!=null) {
			rheight = height(root.right)+1>0?height(root.right)+1:-1;
		}
		if(lheight==-1||rheight==-1||rheight-1>lheight||lheight-1>rheight) {
			return -1;
		}
		return rheight>lheight?rheight:lheight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
