package amazon;

import java.util.HashMap;

public class _460_LFUCache {

    private HashMap<Integer, Value> map;

    private final int capacity;
    private int size = 0;

    class Value {
        int key;
        int val;
        Value previous;
        Value after;
        Header header;

        public Value(int key, int val) {
            super();
            this.key = key;
            this.val = val;
        }
    }

    class Header {
        Value head;
        Value tail;
        Header nextLevel;
    }

    Header root;

    public _460_LFUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        root = new Header();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        Value ret = map.getOrDefault(key, null);
        if (ret == null) {
            return -1;
        } else {
            Header header = ret.header;
            if (header.head == ret && header.tail == ret) {
                header.head = header.tail = null;
            } else if (header.head == ret) {
                header.head = header.head.after;
                header.head.previous = null;
            } else if (header.tail == ret) {
                header.tail = header.tail.previous;
                header.tail.after = null;
            } else {
                Value prev = ret.previous;
                Value aft = ret.after;
                prev.after = aft;
                aft.previous = prev;
            }
            ret.after = ret.previous = null;

            if (header.nextLevel == null) {
                header.nextLevel = new Header();
            }

            header = header.nextLevel;
            ret.header = header;
            if (header.tail != null) {
                Value tail = header.tail;
                tail.after = ret;
                ret.previous = tail;
                ret.after = null;
                header.tail = ret;
            } else {
                header.head = header.tail = ret;
                ret.previous = null;
                ret.after = null;
            }
            return ret.val;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Value val = new Value(key, value);
        val.header = root;
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }
        if (size == capacity) {
            Header toDelete = root;
            while (toDelete.head == null) {
                toDelete = toDelete.nextLevel;
            }

            map.remove(toDelete.head.key);

            toDelete.head = toDelete.head.after;
            if (toDelete.head != null) {
                toDelete.head.previous.after = null;
                toDelete.head.previous = null;
            } else {
                toDelete.tail = null;
            }
            size--;
        }
        if (root.tail != null) {
            root.tail.after = val;
            val.previous = root.tail;

            root.tail = val;
        } else {
            root.head = root.tail = val;
        }

        map.put(key, val);
        size++;
    }

    public static void main(String[] args) {
        _460_LFUCache s = new _460_LFUCache(10);
        String cmd = "[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]";
        String[] cmds = cmd.split("\\[");

        System.out.println(cmds[1]);
        System.out.println(cmds[cmds.length - 1]);
        for (int i = 1; i < cmds.length - 1; i++) {
            String[] inter = (cmds[i].substring(0, cmds[i].length() - 2)).split(",");
            if (inter.length == 1) {
                s.get(Integer.valueOf(inter[0]));
            } else {
                s.put(Integer.valueOf(inter[0]), Integer.valueOf(inter[1]));
            }
        }
        s.put(11, 26);
    }
}
