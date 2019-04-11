package easy;

public class _160_Intersection_of_Two_Linked_Lists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int al=0,bl=0;
		ListNode ta=headA,tb=headB;
		while(ta!=null) {
			al++;
			ta=ta.next;
		}
		while(tb!=null) {
			bl++;
			tb=tb.next;
		}
		ta=headA;
		tb=headB;
		if(al>bl) {
			while(al>bl) {
				ta=ta.next;
				al--;
			}
		}
		if(bl>al) {
			while(bl>al) {
				tb=tb.next;
				bl--;
			}
		}
		while(al>0) {
			al--;
			if(ta==tb) return ta;
			ta=ta.next;
			tb=tb.next;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_160_Intersection_of_Two_Linked_Lists t =new _160_Intersection_of_Two_Linked_Lists();
	}

}
