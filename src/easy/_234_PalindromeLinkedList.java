package easy;

public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        ListNode pre = slow;
        slow = slow.next;
        fast.next = null;

        while (slow != null) {
            fast = slow.next;
            slow.next = pre;
            pre = slow;
            slow = fast;
        }
        slow = head;
        fast = pre;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

}
