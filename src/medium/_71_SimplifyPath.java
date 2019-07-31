package medium;

public class _71_SimplifyPath {
    class FileNode {

        String name;

        FileNode parent;

        public FileNode(String name) {
            super();
            this.name = name;
        }

        @Override
        public String toString() {
            return "/" + name;
        }

    }

    public String simplifyPath(String path) {
        FileNode head = null;
        FileNode tail = null;
        FileNode current = new FileNode("");

        char[] s = path.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '/') {
                continue;
            }

            if (s[i] != '.') {
                StringBuilder name = new StringBuilder();
                while (s[i] != '/') {
                    name.append(s[i]);
                    i++;
                    if (i >= s.length) {
                        break;
                    }
                }
                if (head == null && tail == null) {
                    head = new FileNode(name.toString());
                    tail = head;
                    current = head;
                } else {
                    tail = new FileNode(name.toString());
                    tail.parent = current;
                    current = tail;
                }
            } else {
                int count = 0;
                while (s[i] == '.') {
                    count++;
                    i++;
                    if (i >= s.length) {
                        break;
                    }
                }
                if (i < path.length() && s[i] != '/') {
                    StringBuilder name = new StringBuilder();
                    while (count-->0) {
                        name.append('.');
                    }
                    while (s[i] != '/') {
                        name.append(s[i]);
                        i++;
                        if (i >= s.length) {
                            break;
                        }
                    }
                    if (head == null && tail == null) {
                        head = new FileNode(name.toString());
                        tail = head;
                        current = head;
                    } else {
                        tail = new FileNode(name.toString());
                        tail.parent = current;
                        current = tail;
                    }
                } else {
                    if (count == 2) {
                        if (current.parent == null) {
                            head = new FileNode("");
                            current.parent = head;
                        }
                        current = current.parent;
                    }
                    if (count == 3) {
                        if (head == null && tail == null) {
                            head = new FileNode("...");
                            tail = head;
                            current = head;
                        } else {
                            tail = new FileNode("...");
                            tail.parent = current;
                            current = tail;
                        }
                    }
                }
            }
        }
        StringBuilder addr = new StringBuilder();
        while (current != null) {
            addr.insert(0, current.toString());
            if (current.parent != null && current.parent.name.equals("")) {
                break;
            }
            current = current.parent;
        }
        return addr.toString();
    }

    public static void main(String[] args) {
        _71_SimplifyPath s = new _71_SimplifyPath();
        System.out.println(s.simplifyPath("/..a"));
    }

}
