package amazon;

import java.util.ArrayList;
import java.util.List;

public class _103BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> output;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        /*
        Queue<TreeNode> q = new Deque<TreeNode>();
        q.add(root);
        DeepthTreeNode temp;
        List<Integer> currentLevel = new List<Integer>();
        output.add(new)
        while (!q.isEmpty()) {
            temp = new DeepthTreeNode(q.poll());
            currentLeve.add(temp.val);
            
        }*/
        output = new ArrayList<List<Integer>>();
        int depth = 0;
        Traverse(root, 0);
        while (depth < output.size()) {
            if(depth %2 != 0) {
                List<Integer> temp = new ArrayList<Integer>();
                while (output.get(depth).size() > 0) {
                    temp.add(
                        output.get(depth)
                        .get((output.get(depth).size() - 1)));
                    output.get(depth).remove((output.get(depth).size() - 1));
                }
                output.set(depth, temp);
            }
            depth++;
        }
        return output;
    }
    void Traverse(TreeNode node, int depth) {
        if (node == null) return;
        if (output.size() < depth + 1) {
                output.add(new ArrayList<Integer>());
        }
        
        output.get(depth).add(node.val);
        Traverse(node.left, depth + 1);
        Traverse(node.right, depth + 1);
    }
}
