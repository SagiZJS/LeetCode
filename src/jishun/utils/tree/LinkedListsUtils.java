package jishun.utils.tree;

public class LinkedListsUtils {
    public static ListNode linkedListFactory(int... vals) {
        if (vals.length == 0) return null;
        ListNode root = new ListNode(vals[0]);
        ListNode swap = root;
        for (int j = 1; j < vals.length; j++) {
            swap.next = new ListNode(vals[j]);
            swap = swap.next;
        }
        return root;
    }

    public static void printLinkedLists(ListNode root) {
        while (root != null) {

            System.out.print("" + root.val + "=>");
            root = root.next;
        }
        System.out.println();
    }
}
