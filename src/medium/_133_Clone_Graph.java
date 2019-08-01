package medium;

import java.util.ArrayList;
import java.util.List;

public class _133_Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node[] nodes = new Node[100]; // need to expand
        return recursion(nodes, node);
    }

    public Node recursion(Node[] nodes, Node root) {
        Node newRoot = new Node(root.val,new ArrayList<_133_Clone_Graph.Node>());
        nodes[root.val] =newRoot;
        for (int i = 0; i < root.neighbors.size();i++) {
            Node neighbor = root.neighbors.get(i);
            if (nodes[neighbor.val] == null) {
                newRoot.neighbors.add(recursion(nodes, neighbor));
            } else {
                newRoot.neighbors.add(nodes[neighbor.val]);
            }
        }
        return newRoot;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
