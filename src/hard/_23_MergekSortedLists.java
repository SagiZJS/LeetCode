package hard;


import jishun.utils.tree.LinkedListsUtils;
import jishun.utils.tree.ListNode;

public class _23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists[0] == null) {
            return null;
        }
        int size = lists.length;
        while (size > 1) {
            for (int i = 0; i < size / 2; i++) {
                lists[i] = mergeLists(lists[2 * i], lists[2 * i + 1]);
            }
            if (size > 1 && size % 2 == 1) {
                lists[(size - 1) / 2] = lists[size - 1];
                size++;
            }
            size = size / 2;

        }
        return lists[0];
    }

    private ListNode mergeLists(ListNode node1, ListNode node2) {
        if (node2 == null) return node1;
        if (node1 == null) return node2;
        ListNode root = null;
        ListNode tail = null;
        if (node1.val > node2.val) {
            root = node2;
            tail = node2;
            node2 = node2.next;
        } else {
            root = node1;
            tail = node1;
            node1 = node1.next;
        }
        while (true) {
            if (node1 == null) {
                tail.next = node2;
                break;
            }
            if (node2 == null) {
                tail.next = node1;
                break;
            }
            if (node1.val > node2.val) {
                // node2
                tail.next = node2;
                node2 = node2.next;
            } else {
                // node1
                tail.next = node1;
                node1 = node1.next;
            }
            tail = tail.next;
        }
        return root;
    }
   

    

    public static void main(String[] args) {
        ListNode[] testcase = new ListNode[] { 
                LinkedListsUtils.linkedListFactory(), 
                LinkedListsUtils.linkedListFactory(-3,-3,-2,-1,0), 
                };
        _23_MergekSortedLists s = new _23_MergekSortedLists();

        LinkedListsUtils.printLinkedLists(s.mergeKLists(testcase));
//        LinkedListsUtils.printLinkedLists(s.mergeLists2());
    }
}
