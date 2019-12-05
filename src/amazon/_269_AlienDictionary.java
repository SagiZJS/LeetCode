package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _269_AlienDictionary {
    int depth = 0;

    public String alienOrder(String[] words) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[26];
        for (int i=0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        recursiveAddEdge(graph, Arrays.asList(words));

        int[] color = new int[26];
        int[] start = new int[26];
        int[] end = new int[26];
        for (int i = 0; i < 26; i++) {
            if (color[i] == 0) {
                if (dfs(i, graph, color, start, end)) {
                    return "";
                }
            }
        }
        boolean[] exist = new boolean[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                exist[c - 'a'] = true;
            }
        }
        String[] ret = new String[52];
        for (int i = 0; i < 26; i++) {
            if (!exist[i]) {
                continue;
            }
            String c = "" + (char) ('a' + i);
            int index = end[i];
            ret[index] = "" + c;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : ret) {
            if (s != null) {
                builder.insert(0, s);
            }
        }
        return builder.toString();
    }

// 0 whit 1 gray 2 black;
    public boolean dfs(int u, List<Integer>[] graph, int[] color, int[] start, int[] end) {
        color[u] = 1;
        start[u] = depth++;

        List<Integer> children = graph[u];
        for (int v : children) {
            if (color[v] == 0) {
                if (dfs(v, graph, color, start, end)) {
                    return true;
                }
            } else if (color[v] == 1) {
                return true;
            }
        }
        end[u] = depth++;
        color[u] = 2;
        return false;
    }

    public void recursiveAddEdge(List<Integer>[] graph, List<String> words) {
        @SuppressWarnings("unchecked")
        List<String>[] nextLevelWords = new ArrayList[26];
        int i = -1;
        char lastC = ' ';
        String lastString = null;
        ;
        Iterator<String> iter = words.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.length() == 0) continue;
            char c = s.charAt(0);
            if (c != lastC) {
                if (lastC != ' ') {
                    graph[lastC - 'a'].add(c - 'a');
                }
                lastC = c;
                lastString = s;
                continue;
            } else {
                if (lastString != null) {
                    i++;
                    nextLevelWords[i] = new ArrayList<>();

                    nextLevelWords[i].add(lastString.substring(1));
                    lastString = null;
                }
                nextLevelWords[i].add(s.substring(1));
            }
        }
        for (int index = 0; index <= i; index++) {
            recursiveAddEdge(graph, nextLevelWords[index]);
        }

    }
}
