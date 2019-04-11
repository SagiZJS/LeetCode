package easy;

public class _83_Remove_Duplicates_from_Sorted_List {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode temp = head;
		ListNode tl = temp;
		while (true) {
			tl = tl.next;
			if (tl == null) {
				temp.next=null;
				return head;
			}
			if (tl.val != temp.val) {
				temp.next=tl;
				temp=tl;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNode {
	int val;
	ListNode next;
}
