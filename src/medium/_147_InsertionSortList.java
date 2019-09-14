package medium;

public class _147_InsertionSortList {
//    public ListNode insertionSortList(ListNode head) {
//        if (head==null ) {
//            return null;
//        }
//        ListNode i = head;
//        ListNode ip = null;
//        ListNode j = null;
//        ListNode jp = null;
//        while (i != null) {
//            j = head;
//            jp = null;
//            while (j != i) {
//                if (j.val > i.val) {
//                    if (jp == null) {
////                        ListNode temp = i;
//                        ip.next = i.next;
//                        i.next = head;
//                        head = i;
//                        i = ip;
//                        break;
//                    } else {
//                        ListNode temp = i.next;
//                        ip.next = j;
//                        jp.next = i;
//                        i.next = j.next;
//                        j.next = temp;
//                        break;
//                    }
//                }
//                jp = j;
//                j = j.next;
//
//            }
//            while (i!=null &&i.next.val>i.val) {
//                i = i.next;
//            }
//            ip = i;
//            i = i.next;
//        }
//        return head;
//    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val >= tail.val) {
                tail = current;
            } else if (current.val <= head.val) {
                tail.next = current.next;
                current.next = head;
                head = current;
                current = tail;
            } else if (current.val < tail.val) {
                ListNode temp = head;
                while (temp != tail) {
                    if (temp.next.val > current.val) {
                        tail.next = current.next;
                        current.next = temp.next;
                        temp.next = current;
                        current = tail;
                        break;
                    }
                    temp = temp.next;
                }
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode temp = head;
        head.next = new ListNode(5);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(1);
        head = head.next;
        head.next = new ListNode(8);
        head = head.next;
        head.next = new ListNode(7);
        head = head.next;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;

        _147_InsertionSortList s = new _147_InsertionSortList();
        temp = s.insertionSortList(temp);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
