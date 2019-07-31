package medium;

public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        k = len - k;
        temp = head;
        ListNode newHead = head;
        while (k-- > 1) {
            newHead = newHead.next;
        }
        temp = newHead.next;
        newHead.next = null;
        newHead = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }
}
