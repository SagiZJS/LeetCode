package amazon;

public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = l1;
        ListNode prev = null;
        boolean forward = false;

        while (l1 != null && l2 != null) {

            l1.val = l1.val + l2.val;
            if (forward) {
                l1.val++;
            }
            forward = l1.val >= 10;
            l1.val %= 10;

            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            prev.next = l2;
            l1 = l2;
        }
        
        while (forward) {
            if (l1 == null) {
                l1 = new ListNode(1);
                prev.next = l1;
                forward = false;
            } else {
                l1.val++;
                forward = false;
                if (l1.val > 9) {
                    l1.val = 0;
                    forward = true;
                    prev = l1;
                    l1 = l1.next;
                }
            }
        }

        return root;
    }
}
