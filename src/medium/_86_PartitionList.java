package medium;

public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigTail = null;
        ListNode tail = head;
        while (tail != null) {
            if (tail.val < x) {
                if (smallHead == null) {
                    smallHead = tail;
                    smallTail = tail;
                    tail = tail.next;
                } else {
                    smallTail.next = tail;
                    smallTail = smallTail.next;
                    tail = tail.next;
                }
                smallTail.next = null;
            } else {
                if (bigHead == null) {
                    bigHead = tail;
                    bigTail = tail;
                    tail = tail.next;
                } else {
                    bigTail.next = tail;
                    bigTail = bigTail.next;
                    tail = tail.next;
                }
                bigTail.next = null;
            }
        }
        if (smallTail == null) {
            return bigHead;
        }
        smallTail.next = bigHead;
        return smallHead;
    }
}
