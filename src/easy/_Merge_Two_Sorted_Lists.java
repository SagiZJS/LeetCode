package easy;

/**
 * 
 * @author Sagi
 *
 */

public class _Merge_Two_Sorted_Lists {
	/**
	 * Definition for singly-linked list. 
	 * public class ListNode { 
	 * int val; 
	 * ListNode next; 
	 * ListNode(int x) { val = x; } 
	 * }
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=null;
		ListNode temp=null;
		while(l1!=null&&l2!=null) {
			if(l1.val>l2.val) {
				if(head==null) {
					head = l2;
					temp=head;
					l2=l2.next;
				}else {
					temp.next=l2;
					temp=temp.next;
					l2=l2.next;
				}
			}else {
				if(head==null) {
					head = l1;
					temp=head;
					l1=l1.next;
				}else {
					temp.next=l1;
					temp=temp.next;
					l1=l1.next;
				}
			}
		}
		if(head==null) {
			if(l1!=null) {
				head=l1;
				l1=null;
			} else if(l2!=null) {
				head=l2;
				l2=null;
			}
		}
		if(l1!=null) {
			temp.next=l1;
		} else if(l2!=null) {
			temp.next=l2;
		}
		return head;
	}
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) {
//		ListNode l11 =new ListNode(1);
//		ListNode l12 =new ListNode(2);
//		ListNode l14 =new ListNode(4);
//		l11.next=l12;
//		l12.next=l14;
//		ListNode l21 =new ListNode(1);
//		ListNode l23 =new ListNode(3);
//		ListNode l24 =new ListNode(4);
//		l21.next=l23;
//		l23.next=l24;
////		
//		ListNode head = mergeTwoLists(l11, l21);
//		System.out.println("1");
//		while(head.next!=null) {
//			System.out.println(""+head.val+"->");
//			head =head.next;
//		}
	}
}
