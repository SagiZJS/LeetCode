package easy;

import java.util.*;

public class _111_Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
		Queue<TD> q =new ArrayDeque<TD>();
		if(root==null) return 0;
		q.add(new TD(root,1));
		TD temp=null;
		TreeNode value=null;
		while(!q.isEmpty()) {
			temp=q.poll();
			value=temp.value;
			if(value.right==null&&value.left==null) {
				return temp.depth;
			}
			if(value.right!=null) {
				q.add(new TD(value.right, temp.depth+1));
			}
			if(value.left!=null) {
				q.add(new TD(value.left, temp.depth+1));
			}
		}
		return 0;
	}
	class TD {
		TreeNode value;
		int depth;
		public TD(TreeNode value, int depth) {
			super();
			this.value = value;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
