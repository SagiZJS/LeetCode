package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _187_RepeatedDNASequences {
    class StringNode {
        String val;
        StringNode next;
        boolean visited = false;

        public StringNode(String val) {
            super();
            this.val = val;
        }

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();

        HashMap<Integer, StringNode> map = new HashMap<>();
        StringBuilder dnaString = new StringBuilder();
        if (s.length() > 10) {
            dnaString.append(s.substring(0, 10));
            map.put(dnaString.toString().hashCode(), new StringNode(dnaString.toString()));
            int i = 10;
            while (i < s.length()) {
                dnaString.deleteCharAt(0);
                dnaString.append(s.charAt(i));
                if (map.containsKey(dnaString.toString().hashCode())) {
                    StringNode temp = map.get(dnaString.toString().hashCode());
                    while (true) {
                        if (temp.val.equals(dnaString.toString())) {
                            if (!temp.visited) {
                                temp.visited = true;
                                result.add(dnaString.toString());
                            }
                            break;
                        }
                        if (temp.next == null) {
                            temp.next = new StringNode(dnaString.toString());
                            break;
                        }
                        temp = temp.next;
                    }
                    
                } else {
                    map.put(dnaString.toString().hashCode(), new StringNode(dnaString.toString()));
                }
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _187_RepeatedDNASequences s = new _187_RepeatedDNASequences();
        for (String str : s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")) {
            System.out.println(str);
        }
    }
}
