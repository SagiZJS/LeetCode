package easy;
import java.util.*;
public class _100_Same_Tree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> s1=new Stack<TreeNode>(),s2=new Stack<TreeNode>();
		if(p==null&&q==null) {
			return true;
		} else if( p==null||q==null) {
			return false;
		}
		s1.push(p);
		s2.push(q);
		TreeNode temp1=null;
		TreeNode temp2=null;
		
		while(s1.size()>0&&s2.size()>0) {
			temp1=s1.pop();
			temp2=s2.pop();
			if(temp1.val!=temp2.val||(temp1.right!=null&&temp2.right==null)||(temp1.left==null&&temp2.left!=null)||(temp1.right==null&&temp2.right!=null)||(temp1.left!=null&&temp2.left==null)) {
				return false;
			}
			if(temp1.right!=null) {
				s1.push(temp1.right);
				s2.push(temp2.right);
			}
			if(temp1.left!=null) {
				s1.push(temp1.left);
				s2.push(temp2.left);
			}
		}
		if(s1.size()!=s2.size()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(1>0|1>0);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
