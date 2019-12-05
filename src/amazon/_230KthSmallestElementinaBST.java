package amazon;


public class _230KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int ret = 0;
        
        int[] res = new int[1];
        recursiveSearh(root, k, res, 0);
        ret = res[0];
        return ret;
    }
    
    public int recursiveSearh(TreeNode root, int k, int[] res, int count) {
        if (root == null) {
            return 0;
        }
        if (k == count) {
            return count;
        }
        if (root.left != null) {
            count = recursiveSearh(root.left, k, res, count);
            if (count == k) {
                return count;
            }
        }
        
        if (++count == k) {
            res[0] = root.val;
            return count;
        }
        
        if (root.right != null) {
            count = recursiveSearh(root.right, k, res, count);
        }
        return count;
    }
}
