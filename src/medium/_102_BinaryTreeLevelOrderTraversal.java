package medium;

import java.util.ArrayList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
    class TreeNode2 extends TreeNode {
        int level;

        TreeNode2(int x, int level) {
            super(x);
            this.level = level;
        }

        TreeNode2(TreeNode node, int level) {
            super(node.val);
            this.level = level;
            this.left = node.left;
            this.right = node.right;
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> line = new ArrayList<>();
        List<TreeNode2> queue = new ArrayList<>();
        int head = 0;

        TreeNode2 temp = null;
        int level = 0;
        queue.add(new TreeNode2(root, 0));
        while (queue.size() > head) {
            temp = queue.get(head++);
            if (level != temp.level) {
                result.add(new ArrayList<>(line));
                line.clear();
                level = temp.level;
            }
            line.add(temp.val);
            if (temp.left != null) {
                queue.add(new TreeNode2(temp.left, level+1));
            }
            if (temp.right != null) {
                queue.add(new TreeNode2(temp.right, level+1));
            }
        }
        result.add(new ArrayList<>(line));

        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        _102_BinaryTreeLevelOrderTraversal s = new _102_BinaryTreeLevelOrderTraversal();
        s.levelOrder(root);
    }
}
