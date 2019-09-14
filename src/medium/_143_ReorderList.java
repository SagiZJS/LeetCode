package medium;

public class _143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode[] table = new ListNode[200];
        ListNode temp = head;
        int index = 0;
        while (temp != null) {
            table[index++] = temp;
            if (index == table.length) {
                table = expand(table);
            }
            temp = temp.next;
        }
        int headPointer = 0;
        int tailPointer = index - 1;
        while (tailPointer > headPointer) {
            table[headPointer++].next = table[tailPointer];
            table[tailPointer--].next = table[headPointer];
        }
        if (headPointer == tailPointer) {
            table[headPointer].next = null;
        } else {
            table[headPointer].next = null;
        }
    }

    public ListNode[] expand(ListNode[] origin) {
        ListNode[] newArray = new ListNode[origin.length * 2];
        System.arraycopy(origin, 0, newArray, 0, origin.length);
        return newArray;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        _143_ReorderList s = new _143_ReorderList();
        s.reorderList(root);
    }
}
