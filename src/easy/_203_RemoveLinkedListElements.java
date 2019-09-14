package easy;

public class _203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        while (true) {
            if (temp == null) {
                return head;
            }
            if (temp.next != null) {
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            } else {
                return head;
            }
        }
    }
}
