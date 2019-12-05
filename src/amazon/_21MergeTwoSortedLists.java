package amazon;

public class _21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        } 
        if (l1 == null) {
            return l2;
        }
        ListNode ret = null;
        ListNode current = null;
        if (l1.val < l2.val) {
            ret = l1;
            l1 = l1.next;
        } else {
            ret = l2;
            l2 = l2.next;
        }
        current = ret;
        while (l1 != null && l2 != null) {
            if (l1.val<l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            current.next = l1;
            current = current.next;
            l1 =l1.next;
        }
        while (l2 != null) {
            current.next = l2;
            current = current.next;
            l2 =l2.next;
        }
        return ret;
    }
}
