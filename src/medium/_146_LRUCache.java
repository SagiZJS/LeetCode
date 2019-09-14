package medium;

public class _146_LRUCache {

    private final Entry[] table;

    @SuppressWarnings("unused")
    private final int capacity;
    private final int capacity2;
    private Entry tail = null;
    private Entry head = null;
    private int count = 0;

    private static class Entry {
        private final int key;
        private final int val;
        private Entry previous;
        private Entry after;
        private Entry next;

        public Entry(int key, int val) {
            super();
            this.key = key;
            this.val = val;
        }

    }

    private int getHash(int key) {
        return key % capacity2;
    }

    public _146_LRUCache(int capacity) {
        this.capacity = (int) (capacity * 1.25);
        this.capacity2 = capacity;
        table = new Entry[capacity];
    }

    public int get(int key) {
        Entry res = table[getHash(key)];
        while (res != null) {
            if (res.key == key && res != tail) {
                if (head == res) {
                    head = head.after;
                }
                if (res.previous != null) {
                    res.previous.after = res.after;
                }
                if (res.after != null) {
                    res.after.previous = res.previous;
                }
                if (res != tail) {
                    res.previous = tail;
                    tail.after = res;
                    res.after = null;
                    tail = res;
                }

                return res.val;
            }
            res = res.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (count == capacity2) {
            deleteEntryFromTable(head);
            count--;
            if (capacity2 != 1) {

                head = head.after;
                head.previous.after = null;
                head.previous.next = null;
                head.previous = null;
            }
        }
        Entry temp = new Entry(key, value);
        if (count == 0) {
            head = tail = temp;
        } else {
            if (temp != tail) {
                tail.after = temp;
                temp.previous = tail;
                tail = temp;
            }
        }
        int index = getHash(key);

        if (table[index] == null) {
            table[index] = temp;
        } else {
            Entry tailEntry = table[index];
            while (tailEntry.next != null) {
                if (tailEntry.key == key) {
                    return;
                }
                tailEntry = tailEntry.next;
            }
            tailEntry.next = temp;
        }
        count++;
    }

    private void deleteEntryFromTable(Entry e) {
        Entry toDelete = table[getHash(e.key)];
        if (toDelete.key == e.key) {
            table[getHash(e.key)] = table[getHash(e.key)].next;
        } else {
            while (toDelete.next.key != e.key) {
                toDelete = toDelete.next;
            }
            toDelete.next = toDelete.next.next;
        }
    }

    public static void main(String[] args) {
        _146_LRUCache s = new _146_LRUCache(10);
        test1(s);
    }

    public static void test2(_146_LRUCache s) {
        s.put(7, 28);
        s.put(7, 1);
        s.put(8, 15);
        s.get(6);
        s.put(10, 27);
        s.put(8, 10);
        s.get(8);
        s.put(6, 29);
        s.put(1, 9);
        s.get(6);
        s.put(10, 7);
        s.get(1);
        s.get(2);
        s.get(13);
        s.put(8, 30);
        s.put(1, 5);
        s.get(1);
        s.put(13, 2);
        s.get(12);
    }

    public static void test1(_146_LRUCache s) {
        s.put(10, 13);

        s.put(3, 17);
        s.put(6, 11);
        s.put(10, 5);
        s.put(9, 10);
        s.get(13);
        s.put(2, 19);
        s.get(2);
        s.get(3);
        s.put(5, 25);
        s.get(8);
        s.put(9, 22);
        s.put(5, 5);
        s.put(1, 30);
        s.get(11);
        s.put(9, 12);
        s.get(4);
        s.get(5);
        s.get(8);
        s.get(9);
        s.put(4, 30);
        s.put(9, 3);
        s.get(9);
        s.get(10);
        s.get(10);
        s.put(6, 14);
        s.put(3, 1);
        s.get(3);
        s.put(10, 11);
        s.get(8);
        s.put(2, 14);
        s.get(1);
        s.get(5);
        s.get(4);
        s.put(11, 4);
        s.put(12, 24);
        s.put(5, 18);
        s.get(13);
        s.put(7, 23);
        s.put(7, 23);
        System.out.println("1");
    }
}
