package medium;

public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return mergeSort(head, tail);
    }

    public ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = mergeSort(slow.next, tail);
        slow.next = null;
        ListNode left = mergeSort(head, slow);
        head = null;
        tail = null;
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (head == null) {
                    head = left;
                    tail = left;
                } else {
                    tail.next = left;
                    tail = tail.next;
                }
                left =left.next;
            } else {
                if (head == null) {
                    head = right;
                    tail = right;
                } else {
                    tail.next = right;
                    tail = tail.next;
                }
                right = right.next;
            }
        }
        while (left != null) {
            if (head == null) {
                head = left;
                tail = left;
            } else {
                tail.next = left;
                tail = tail.next;
            }
            left = left.next;
        }
        while (right != null) {
            if (head == null) {
                head = right;
                tail = right;
            } else {
                tail.next = right;
                tail = tail.next;
            }
            right = right.next;
        }
        tail .next = null;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode temp = new ListNode(2);
        head.next = temp;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        
        _148_SortList s = new _148_SortList();
        temp = s.sortList(head);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
