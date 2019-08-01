package medium;

public class _116_PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node[] queue = new Node[200];
        int count = 0;
        int divider = 2;
        int tail = 0;
        int head = 0;
        queue[tail++] = root;
        Node temp = null;
        Node lastNode = null;
        while (tail - head > 0) {
            temp = queue[head++];
            count++;
            if (count / divider == 1) {
                divider = divider << 1;
                lastNode = temp;
            } else if (lastNode != null) {
                lastNode.next = temp;
                lastNode = temp;
            }
            if (temp.left != null) {
                queue[tail++] = temp.left;
                if (tail == queue.length) {
                    queue = queueExpand(queue);
                }
            }
            if (temp.right != null) {
                queue[tail++] = temp.right;
                if (tail == queue.length) {
                    queue = queueExpand(queue);
                }
            }
        }
        return root;
    }

    public Node[] queueExpand(Node[] queue) {
        Node[] newStack = new Node[queue.length * 2];
        System.arraycopy(queue, 0, newStack, 0, queue.length);
        return newStack;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node();
        root.left.val = 2;
        root.left.left = new Node();
        root.left.left.val = 4;
        root.left.right = new Node();
        root.left.right.val = 5;
        root.right = new Node();
        root.right.val = 3;
        root.right.left = new Node();
        root.right.left.val = 6;
        root.right.right = new Node();
        root.right.right.val = 7;
        _116_PopulatingNextRightPointersinEachNode s = new _116_PopulatingNextRightPointersinEachNode();
        s.connect(root);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

// {"$id":"1","left":{"$id":"2","left":,"next":,"right":,"val":2},"next":{"$ref":"5"},"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
//{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":{"$ref":"4"},"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":{"$ref":"5"},"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

//{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":{"$ref":"2"},"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":{"$ref":"6"},"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
