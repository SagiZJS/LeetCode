package medium;

import java.util.HashSet;
import java.util.Set;

public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tail = null;
        ListNode root = head;
        while (head.next != null) {
            if (set.contains(head.next)) {
                tail = head.next;
                break;
            }
            set.add(head);
            head = head.next;
        }
        while (tail != null) {
            if (root.equals(tail)) {
                return root;
            }
            root = root.next;
        }
        return null;
    }


    public static void main(String[] args) {
    }

}
