package medium;

public class _211_AddandSearchWordDatastructuredesign {

    private final TrieNode root;
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public _211_AddandSearchWordDatastructuredesign() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        
        for (int i = 0;i<word.length();i++) {
            int val = word.charAt(i) - 'a';
            if (temp.children[val] == null) {
                temp.children[val] = new TrieNode();
            }
            temp = temp.children[val];
        }
        temp.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return recursionSearch(word, 0, root);
    }
    public boolean recursionSearch(String word, int index, TrieNode temp) {
        if (temp == null) {
            return false;
        }
        if (index == word.length()) {
            return temp.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for(int i = 0; i < 26; i++) {
                if(recursionSearch(word, index + 1, temp.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return recursionSearch(word, index + 1, temp.children[word.charAt(index) - 'a']);
        }
    }
    
    public static void main(String[] args) {
        _211_AddandSearchWordDatastructuredesign s = new _211_AddandSearchWordDatastructuredesign();
        s.addWord("bad");
        s.addWord("dad");
        s.addWord("mad");
        System.out.println(s.search("pad"));
        System.out.println(s.search("bad"));
        System.out.println(s.search(".ad"));
        System.out.println(s.search(".a."));
    }
}
