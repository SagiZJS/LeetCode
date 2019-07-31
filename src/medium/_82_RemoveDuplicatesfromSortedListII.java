package medium;

public class _82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = null;
        ListNode tail = head;
        ListNode listEnd = null;
        if (head.next == null) {
            return head;
        }
        while (tail.next != null) {
            if (tail.next.val != tail.val) {
                if (root == null) {
                    root = tail;
                }
                if (listEnd != null) {
                    listEnd.next = tail;
                }
                listEnd = tail;
            } else {
                if (listEnd != null) {
                    listEnd.next = null;
                }
                while (tail.next != null && tail.val == tail.next.val) {
                    tail = tail.next;
                }
                if (tail.next == null) {
                    listEnd = null;
                    return root;
                }
            }
            tail = tail.next;
        }
        if (root == null) {
            return tail;
        }
        if (listEnd != null) {
            listEnd.next = tail;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int[] nums = { 1, 1, 2, 3 };
        for (int i = 0; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        _82_RemoveDuplicatesfromSortedListII s = new _82_RemoveDuplicatesfromSortedListII();
        s.deleteDuplicates(head);
    }
}
