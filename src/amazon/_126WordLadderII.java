package amazon;

import java.awt.Dialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class _126WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ret;
        }
        

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);



        boolean found = false;
        HashMap<String, List<String>> toParents = new HashMap<>();
        
        
        List<String> parentLayer = new ArrayList<>();
        parentLayer.add(beginWord);

        while (true) {
            List<String> newLayer = new ArrayList<>();
            Iterator<String> iter = wordSet.iterator();
            while (iter.hasNext()) {
                String s = iter.next();
                boolean remove = false;
                for (String parent : parentLayer) {
                    String child =s;
                    if (isNeighbored(parent, s)) {
                        remove = true;
                        //node.parents.add(parent);
                        if (toParents.get(child) == null) {
                            toParents.put(child, new ArrayList<>());
                        }
                        toParents.get(child).add(parent);
                        
                        newLayer.add(child);
                        if (s.equals(endWord)) {
                            found = true;
                            
                        }
                    }
                    
                }
                if (remove) {
                    iter.remove();
                }
            }
            if (found) {
                break;
            }
            if (newLayer.size() == 0) {
                break;
            } else {
                parentLayer = newLayer;
            }
        }
        if (toParents.get(endWord) == null) {
            return ret;
        }
        record(ret, new ArrayList<>(), endWord, toParents, beginWord);
        return ret;
    }
    
    void record(List<List<String>> ret, List<String> newPath, String node, HashMap<String, List<String>> toParents, String start) {
        if (node.equals(start)) {
            newPath.add(0, node);
            ret.add(new ArrayList<>(newPath));
            newPath.remove(0);
            return;
        }
        for(String parents : toParents.get(node)) {
            newPath.add(0, node);
            record(ret, newPath, parents, toParents, start);
            newPath.remove(0);
        }
    }

    boolean isNeighbored(String s1, String s2) {
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }
    
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new ArrayList<>();
//        Set<String> words = new HashSet<>(wordList);
//        if(!words.contains(endWord)) return res;
//        
//        Map<String, List<String>> map = new HashMap<>(); // current word and nexts
//        Set<String> startSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        startSet.add(beginWord);
//        endSet.add(endWord);
//        
//        bfs(startSet, map, words, endSet, false);
//        
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        dfs(res, list, endWord, beginWord, map);
//        
//        return res;
//    }
//    
//    private void dfs(List<List<String>> res, List<String> list, String endWord, String curword, Map<String, List<String>> map) {
//        if(curword.equals(endWord)) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        
//        if(map.get(curword) == null) return;
//        for(String next : map.get(curword)) {
//            list.add(next);
//            dfs(res, list, endWord, next, map);
//            list.remove(list.size() - 1);
//        }
//    }
//    
//    private void bfs(Set<String> startSet, Map<String, List<String>> map, Set<String> words, Set<String> endSet, boolean reverse) {
//        if (startSet.size() == 0) return;
//        
//        if (startSet.size() > endSet.size()) {
//            bfs(endSet, map, words, startSet, !reverse);
//            return;
//        }
//        
//        Set<String> nextLevelSet = new HashSet<>(); // next level
//        boolean finish = false;
//        words.removeAll(startSet); // remove processed
//        
//        for (String word : startSet) { // loop through current level
//            char[] curword = word.toCharArray();
//            for (int i = 0; i < curword.length; i++) {
//                char oldchar = curword[i];
//                for (char c = 'a'; c <= 'z'; c++) {
//                    curword[i] = c;
//                    String word_after = new String(curword); // create new word form old ones
//                    
//                    if (words.contains(word_after)) {
//                        if(endSet.contains(word_after)) {
//                            finish = true;
//                        }
//                        else {
//                            nextLevelSet.add(word_after);
//                        }
//                        
//                        String key = reverse ? word_after : word;
//                        String value = reverse ? word : word_after;
//                        
//                        if(map.get(key) == null) {
//                            map.put(key, new ArrayList<>());
//                        }
//                        
//                        map.get(key).add(value);
//                    }
//                }
//                curword[i] = oldchar;
//            }
//        }
//        if(finish == false) {
//            bfs(nextLevelSet, map, words, endSet, reverse);
//        }
//    }

}
