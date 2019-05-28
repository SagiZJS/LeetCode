package medium;

public class _19_RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)return null;
		int len = 0;
		ListNode tail = head;
		while (tail != null) {
			len++;
			tail = tail.next;
		}
		int count = 0;
		tail = head;
        if (n == len) {
            return head.next;
        }
		while (count++ < len - n - 1) {
			tail = tail.next;
		}
		tail.next = tail.next.next;
		return head;
	}
}
