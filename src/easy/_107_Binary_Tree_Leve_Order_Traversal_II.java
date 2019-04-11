package easy;

import java.util.*;

public class _107_Binary_Tree_Leve_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		List<Integer> row =new ArrayList<Integer>();
		Stack<List<Integer>> s =new Stack<List<Integer>>();
		Queue<TD> q = new ArrayDeque<TD>();
		if (root == null)
			return output;
		q.add(new TD(root, 1));
		int nowd = 1;
		TD temp = null;
		TreeNode value = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			value=temp.value;
			if (nowd < temp.depth) {
				s.push(row);
				row = new ArrayList<Integer>();
				nowd=temp.depth;
			}
			row.add(value.val);
			if (value.left != null) {
				q.add(new TD(value.left, temp.depth + 1));
			}
			if (value.right != null) {
				q.add(new TD(value.right, temp.depth + 1));
			}
		}
		s.push(row);
		while(!s.isEmpty()) {
			output.add(s.pop());
		}
		return output;
	}

	class TD {
		TreeNode value;
		int depth;

		public TD(TreeNode value, int depth) {
			this.value = value;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
