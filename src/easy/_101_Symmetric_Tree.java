package easy;

import java.util.Stack;

public class _101_Symmetric_Tree {
	public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		Stack<TreeNode> l =new Stack<TreeNode>(); 
		Stack<TreeNode> r =new Stack<TreeNode>(); 
		TreeNode tl=null,tr=null,temp1=root,temp2=root;
		if((tl=temp1.left)==null&(tr=temp2.right)==null) {
            // System.out.println("l:"+tl+"r:"+tr);
			return true;
		} else if ((tl==null&&tr!=null)||(tl!=null&&tr==null)) {
            // System.out.println("fs");
			return false;
		} else {
			l.push(tl);
			r.push(tr);
		}
        // System.out.println("fsf");
		while(!l.empty()&&!r.empty()) {
			temp1=l.pop();
			temp2=r.pop();
			if(temp1.val!=temp2.val) {
				return false;
			}
			tl=temp1.left;
			tr=temp2.right;
			if(tl!=null&&tr!=null) {
				l.push(tl);
				r.push(tr);
			}else if((tl!=null&&tr==null)||(tl==null&&tr!=null)) {
				return false;
			}
			tl=temp1.right;
			tr=temp2.left;
			if(tl!=null&&tr!=null) {
				l.push(tl);
				r.push(tr);
			}else if(tl!=null||tr!=null) {
				return false;
			}
		}
		if(!l.empty()||!r.empty()) {
			return false;
		}
		return true;
	}
}
