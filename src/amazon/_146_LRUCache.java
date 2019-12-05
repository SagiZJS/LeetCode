package amazon;

public class _146_LRUCache {

    private final Entry[] hashtable;

    private Entry head;
    private Entry tail;

    private final int capacity;
    private final int size;
    private int len = 0;

    private int hash(int key) {
        return (key % size);
    }

    private static class Entry {

        private Entry previous;
        private Entry after;

        private Entry next;

        private int key;
        private int value;

        public Entry(int key, int value) {
            super();
            this.key = key;
            this.value = value;
        }

    }

    public _146_LRUCache(int capacity) {
        size = capacity * 4;
        this.capacity = capacity;
        hashtable = new Entry[size];
    }

    public void put(int key, int value) {
        Entry e = new Entry(key, value);

        // if nothing init

        // compute hash, find out if exists already
        int hash = hash(key);
        Entry current = hashtable[hash];

        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.next;
        }
        // if has key
        if (current != null) {
            current.value = value;
            e = current;
            if (e == tail) {
                // do nothing
            } else if (e == head) {
                head = e.after;
                head.previous = null;

                e.previous = tail;
                tail.after = e;
                tail = e;
                tail.after = null;
            } else {
                e.previous.after = e.after;
                e.after.previous = e.previous;
                e.previous = null;
                e.after = null;

                e.previous = tail;
                tail.after = e;
                tail = e;
            }
        } else {
            if (head == null) {
                head = e;
                tail = e;
            } else {
                // insert into linked list
                tail.after = e;
                e.previous = tail;
                tail = e;
            }
            // insert into hashtable
            e.next = hashtable[hash];
            hashtable[hash] = e;

            if (len == capacity) {
                // delete head from table
                Entry start = hashtable[hash(head.key)];
                if (start == head) {
                    hashtable[hash(head.key)] = start.next;
                } else {
                    while (start.next.key != head.key) {
                        start = start.next;
                    }
                    start.next = start.next.next;
                }

                // delete head from linkedlist
                head = head.after;
                head.previous = null;

                len--;
            }

            // with the map
            // delete from map
            // TODO

            len++;
        }
    }

    public int get(int key) {
        Entry e = hashtable[hash(key)];
        while (e != null) {
            if (e.key == key) {
                // update linked list ()
                if (e == tail) {
                    // do nothing
                } else if (e == head) {
                    head = e.after;
                    head.previous = null;
                    
                    e.previous =tail;
                    tail.after = e;
                    tail = e;
                    tail.after = null;
                } else {
                    e.previous.after = e.after;
                    e.after.previous = e.previous;
                    e.previous = null;
                    e.after = null;

                    e.previous = tail;
                    tail.after = e;
                    tail = e;
                }

                return e.value;
            }
            e = e.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        _146_LRUCache s = new _146_LRUCache(3);
        s.put(1, 1);
        s.put(2, 2);
        s.put(3, 3);
        s.put(4, 4);
        s.get(4);
        s.get(3);
        s.get(2);
        s.get(1);
        s.put(5, 5);
        s.get(1);
        s.get(2);
        s.get(3);
        s.get(4);
        s.get(5);
    }
}
