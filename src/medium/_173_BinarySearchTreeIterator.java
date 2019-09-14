package medium;

import java.util.ArrayList;
import java.util.List;

public class _173_BinarySearchTreeIterator {
    List<Integer> res = new ArrayList<Integer>();

    int current = 0;
    int max = 0;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        traverse(root);
        max = res.size();
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return ;
        }
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return res.get(current++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current < max;
    }
}
