package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String charArray = getString(s);
            if (map.containsKey(charArray)) {
                map.get(charArray).add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(charArray, list);
                ans.add(list);
            }
        }
        return ans;
    }
    private String getString(String s) {
        char[] freq = new char[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return new String(freq);
    }

}
