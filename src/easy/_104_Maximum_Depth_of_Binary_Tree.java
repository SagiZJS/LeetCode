package easy;

import java.util.Stack;

public class _104_Maximum_Depth_of_Binary_Tree {
	public int maxDepth(TreeNode root) {
        Stack<TD> s =new Stack<TD>();
        if(root==null) return 0;
        s.push(new TD(root,1));
        int maxDepth=0;
        TD temp=null;
        TreeNode value=null;
        while(!s.isEmpty()){
            temp = s.pop();
            if(maxDepth<temp.depth){
                maxDepth=temp.depth;
            }
            value = temp.value;
            if(value.left!=null){
                s.push(new TD(value.left,temp.depth+1));
            }
            if(value.right!=null){
                s.push(new TD(value.right,temp.depth+1));
            }
        }
        return maxDepth;
    }
    class TD{
        TreeNode value;
        int depth;
        public TD(TreeNode value,int depth){
            this.value=value;
            this.depth=depth;
        }
    }
	public static void main(String[] args) {

	}

}
