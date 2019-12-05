package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _819_MostCommonWord {
    public class Freq {
        String val;
        int freq = 1;

        public Freq(String val) {
            super();
            this.val = val;
        }

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String p = paragraph.toLowerCase();
        char[] cs = p.toCharArray();
        HashMap<String, Freq> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < cs.length) {
            if (start == end) {
                if (cs[start] > 'z' || (cs[start] < 'a')) {
                    start++;
                }
                end++;
                continue;
            }
            if (cs[end] > 'z' || (cs[end] < 'a')) {
                String key = p.substring(start, end);
                if (map.get(key) == null) {
                    map.put(key, new Freq(key));
                } else {
                    map.get(key).freq++;
                }
                end++;
                start = end;
            } else {
                end++;
            }
        }
        if (start < end) {
            String key = p.substring(start, end);
            if (map.get(key) == null) {
                map.put(key, new Freq(key));
            } else {
                map.get(key).freq++;
            }
            start = end;
        }

        List<Freq> strFreqs = new ArrayList<>(map.values());
        Collections.sort(strFreqs, new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o2.freq - o1.freq;
            }
        });
        
        Set<String> bannedSet =  new HashSet<>();
        for(String ban:banned) {
            bannedSet.add(ban);
        }
        for (int i = 0; i < strFreqs.size(); i++) {
            if (bannedSet.contains(strFreqs.get(i).val)) {
                continue;
            } else {
                return strFreqs.get(i).val;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        _819_MostCommonWord s = new _819_MostCommonWord();
        String[] banned = {"hit"};
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        System.out.println(new String(p.toLowerCase().toCharArray()));
        s.mostCommonWord(p, banned);
    }
}
