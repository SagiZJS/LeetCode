package medium;

public class _117_PopulatingNextRightPointersinEachNodeII {
    static class Node {
        Node left;
        Node next;
        Node right;
        int val;
    }
    class DepthNode {
        int depth;
        Node node;

        public DepthNode(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        DepthNode[] queue = new DepthNode[200];
        int tail = 0;
        int head = 0;
        queue[tail++] = new DepthNode(root, 0);
        DepthNode temp = null;

        DepthNode lastNode = null;
        while (tail - head > 0) {
            temp = queue[head++];
            if (lastNode == null) {
                lastNode = temp;
            } else if (lastNode.depth != temp.depth) {
                lastNode = temp;
            } else if (lastNode != null) {
                lastNode.node.next = temp.node;
                lastNode = temp;
            }
            if (temp.node.left != null) {
                queue[tail++] = new DepthNode(temp.node.left, temp.depth + 1);
                if (tail == queue.length) {
                    queue = queueExpand(queue);
                }
            }
            if (temp.node.right != null) {
                queue[tail++] = new DepthNode(temp.node.right, temp.depth + 1);
                if (tail == queue.length) {
                    queue = queueExpand(queue);
                }
            }
        }
        return root;
    }

    public DepthNode[] queueExpand(DepthNode[] queue) {
        DepthNode[] newStack = new DepthNode[queue.length * 2];
        System.arraycopy(queue, 0, newStack, 0, queue.length);
        return newStack;
    }

}
