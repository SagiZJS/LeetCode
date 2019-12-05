package amazon;

import java.util.ArrayList;
import java.util.List;

import amazon._212_WordSearchII.Trie.TrieNode;

public class _212_WordSearchII {

    public static class Trie {
        class TrieNode {
            String word;
            TrieNode[] children = new TrieNode[26];

            public TrieNode() {
            }
        }

        TrieNode root = new TrieNode();

        public void add(String word) {
            char[] cs = word.toCharArray();
            TrieNode temp = root;
            for (char c : cs) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s:words) {
            trie.add(s);
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                findWord(board, new boolean[board.length][board[0].length], i, j, trie.root, ret);
            }
                
        }
        return ret;
    }

    private void findWord(char[][] board, boolean[][] v, int i, int j, TrieNode node, List<String> ret) {

        if (i < 0 || j < 0 || i == board.length || j == board[0].length || v[i][j]) {
            return;
        }
        char c = board[i][j];
        node = node.children[c - 'a'];
        if (node == null)
            return;
        if (node.word != null) {
            ret.add(node.word);
        }
        v[i][j] = true;

        findWord(board, v, i + 1, j, node, ret);
        findWord(board, v, i - 1, j, node, ret);
        findWord(board, v, i, j + 1, node, ret);
        findWord(board, v, i, j - 1, node, ret);

        v[i][j] = false;
    }
}
