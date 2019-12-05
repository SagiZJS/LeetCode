package easy;

public class _237_DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode prev = node;
        while (node.next != null) {
            node = node.next;
            prev.val = node.val;
            if (node.next == null) {
                prev.next = null;
                return;
            }
            prev = prev.next;
        }
        prev.next = null;

    }
}
