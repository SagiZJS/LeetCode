package easy;

public class _876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode doubleStep = head.next;
        ListNode singleStep = head;
        while (doubleStep != null) {
            doubleStep = doubleStep.next;
            singleStep = singleStep.next;
            if (doubleStep != null) {
                doubleStep = doubleStep.next;
            }
        }
        
        return singleStep;
        
    }

}
