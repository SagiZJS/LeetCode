package amazon;

import java.util.ArrayList;
import java.util.List;

public class _545_BoundaryofBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }
        if (root.left == null && root.right == null) {
            ret.add(root.val);
            return ret;
        }
        List<TreeNode> leftB = new ArrayList<>();
        List<TreeNode> rightB = new ArrayList<>();
        List<TreeNode> leaves = new ArrayList<>();
        TreeNode node = root.left;
        while (node != null) {
            leftB.add(node);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        node = root.right;
        while (node != null) {
            rightB.add(node);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        findLeaves(leaves, root);
        int index = 0;
        ret.add(root.val);
        TreeNode next = null;
        if (leftB.size() != 0) {
            next = leaves.get(0);
            while (true) {
                node = leftB.get(index++);
                if (node == next)
                    break;
                ret.add(node.val);
            }
        }
        index = 0;
        next = null;
        if (rightB.size() != 0) {
            next = rightB.get(rightB.size() - 1);}
        while (index < leaves.size()) {
            node = leaves.get(index++);
            if (node == next)
                break;
            ret.add(node.val);
        }
        
        if (rightB.size() != 0) {
            index = rightB.size() - 1;
            while (index >= 0) {
                node = rightB.get(index--);
                ret.add(node.val);
            }
        }
        return ret;
    }

    public void findLeaves(List<TreeNode> leaves, TreeNode node) {
        if (node.left == null && node.right == null) {
            leaves.add(node);
        }
        if (node.left != null) {
            findLeaves(leaves, node.left);
        }
        if (node.right != null) {
            findLeaves(leaves, node.right);
        }
    }

}
