package medium;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        Object[][] res = new Object[n][n];
        boolean[] used = new boolean[n];
        return recursion(used, 0, n-1, res);
    }

    @SuppressWarnings("unchecked")
    public List<TreeNode> recursion(boolean[] used, int start, int end, Object[][] res) {
        if (start > end) {
            return new ArrayList<>();
        }
         if (res[start][end] != null) {
            return (List<TreeNode>) res[start][end];
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode root = null;
        for (int i = start; i <= end; i++) {
            if (!used[i]) {
                List<TreeNode> left = recursion(used, start, i - 1, res);
                List<TreeNode> right = recursion(used, i+1, end, res);
                if (left.size() != 0 && right.size() != 0) {
                    for (int j = 0; j < left.size(); j++) {
                        for (int k = 0; k < right.size(); k++) {
                            root = new TreeNode(i+1);
                            result.add(root);
                            root.left = left.get(j);
                            root.right = right.get(k);
                        }
                    }
                } else if (left.size() != 0) {
                    for (TreeNode treeNode : left) {
                        root = new TreeNode(i+1);
                        root.left = treeNode;
                        result.add(root);
                    }
                } else if (right.size() != 0) {
                    for (TreeNode treeNode : right) {
                        root = new TreeNode(i+1);
                        root.right = treeNode;
                        result.add(root);
                    }
                } else {
                    root = new TreeNode(i+1);
                    result.add(root);
                }
                
            }
        }
        res[start][end] = result;
        return result;
    }

    public static void main(String[] args) {
        _95_UniqueBinarySearchTreesII s = new _95_UniqueBinarySearchTreesII();
        s.generateTrees(3);
    }
}
