package medium;

import jishun.utils.tree.LinkedListsUtils;
import jishun.utils.tree.ListNode;

public class _92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode root = head;
        ListNode beforeStart = null;
        ListNode afterEnd = null;
        ListNode start = head;
        while (true) {
            if (count == n) {
                break;
            }
            if (count == m - 1) {
                beforeStart = head;
                start = head.next;
            }
            count++;
            head = head.next;
        }
        afterEnd = head.next;
        head.next = null;
        reverseGroup(start, head, n - m + 1);
        if (beforeStart != null) {
            beforeStart.next = head;
        }
        start.next = afterEnd;
        return m == 1 ? head : root;
    }

    private void reverseGroup(ListNode head, ListNode tail, int k) {
        if (k<2) return;
        if (k == 2) {
            head.next.next = head;
        } else {
            ListNode root = head;
            ListNode middle = root.next;
            ListNode last = middle.next;
            while (true) {
                middle.next = root;
                root = middle;
                middle = last;
                last = last.next;
                if (last == null) {
                    middle.next = root;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ListNode root = LinkedListsUtils.linkedListFactory(1, 2);
        _92_ReverseLinkedListII s = new _92_ReverseLinkedListII();
        LinkedListsUtils.printLinkedLists(s.reverseBetween(root, 1,1));
    }
}
