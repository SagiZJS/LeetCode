package hard;

import jishun.utils.tree.LinkedListsUtils;
import jishun.utils.tree.ListNode;

public class _25_ReverseNodesinkGroup {
    

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode output = null;
        ListNode tail = head;
        ListNode lastTail = null;
        int count = 1;
        while (true) {
            count++;
            tail = tail.next;
            if (tail == null) {
                if (lastTail != null) {
                    lastTail.next = head;
                }
                break;
            }
            if (count == k) {
                // reverse and link
                if (output == null) {
                    output = tail;
                }
                if (lastTail != null) {
                    lastTail.next = tail;
                }
                lastTail = head;
                head = tail.next;
                tail.next = null;
                reverseGroup(lastTail, tail, k);
                lastTail.next = null;
                if (head == null) {
                    break;
                }
                tail = head;
                count = 1;
            }
        }
        
        return output == null? head : output;
    }

    private void reverseGroup(ListNode head, ListNode tail, int k) {
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
        ListNode head = LinkedListsUtils.linkedListFactory(1,2,3,4,5);
        _25_ReverseNodesinkGroup s = new _25_ReverseNodesinkGroup();
        LinkedListsUtils.printLinkedLists(s.reverseKGroup(head, 3));
    }
}
