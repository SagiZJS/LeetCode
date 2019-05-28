package medium;

public class _24_SwapNodesinPair {
	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		ListNode first = head;
		ListNode second = head.next;
		ListNode temp;
		if (second != null) {
			head = second;
		}
		while (first != null && second != null) {
			// swap
			first.next = second.next;
			second.next = first;
			// forward
			temp = first;
			first = first.next;
			if (first != null) {
				second = first.next;
				if (second != null) {
					temp.next = second;
					System.out.println(temp.next.val);
				}
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		_24_SwapNodesinPair s = new _24_SwapNodesinPair();
		head = s.swapPairs(head);
		while (head != null) {
			System.out.print("-"+head.val);
			head = head.next;
		}
		
	}
}
