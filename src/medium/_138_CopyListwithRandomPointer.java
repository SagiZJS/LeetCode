package medium;

public class _138_CopyListwithRandomPointer {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node[] nodes = new Node[200];
        Node[] minusNodes = new Node[200];
        return recursionCopy(head, nodes, minusNodes);
    }

    public Node recursionCopy(Node head, Node[] nodes, Node[] minusNodes) {
        Node newHead = null;
        if (head.val >= 0) {
            if (head.val > nodes.length - 1) {
                nodes = expand(nodes, head.val);
            }
            if (nodes[head.val] == null) {
                newHead = new Node(head.val, null, null);
                nodes[head.val] = newHead;
            } else {
                return nodes[head.val];
            }
        } else {
            int index = getIndex(head.val);
            if (index > minusNodes.length - 1) {
                minusNodes = expand(minusNodes, index);
            }
            if (minusNodes[index] == null) {
                newHead = new Node(head.val, null, null);
                minusNodes[index] = newHead;
            } else {
                return minusNodes[index];
            }
        }
        if (head.next != null) {
            newHead.next = recursionCopy(head.next, nodes, minusNodes);
        }
        if (head.random != null) {
            newHead.random = recursionCopy(head.random, nodes, minusNodes);
        }
        return newHead;
    }

    public Node[] expand(Node[] nodes, int val) {
        Node[] newNodes = new Node[val *2];
        System.arraycopy(nodes, 0, newNodes, 0, nodes.length);
        return newNodes;
    }

    public int getIndex(int val) {
        return -val - 1;
    }
    
    public static void main(String[] args) {
        Node root = new Node();
        root.val = -1;
        root.random = root;
        _138_CopyListwithRandomPointer s = new _138_CopyListwithRandomPointer();
        s.copyRandomList(root);
        Node[] test = new Node[12312];
        test[1233] = new Node(123,null,null);
        for (Node node : test) {
            if (node !=null) {
                System.out.println(node.val);
            }
        }
        test = s.expand(test, 12333);
        for (Node node : test) {
            if (node !=null) {
                System.out.println(node.val);
            }
        }
        
    }
}
