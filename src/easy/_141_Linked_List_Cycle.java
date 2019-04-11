package easy;

public class _141_Linked_List_Cycle {
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode s1=head;
		ListNode s2=head;
		while(s2.next!=null) {
			s2=s2.next.next;
			if(s2==null) {return false;}
			s1=s1.next;
			if(s1==s2) {return true;}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
