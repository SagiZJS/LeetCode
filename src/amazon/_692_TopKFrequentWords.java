package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _692_TopKFrequentWords {
    private class Freq {
        String val;
        int freq;

        public Freq(String val) {
            super();
            this.val = val;
            this.freq = 1;
        }

    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Freq> map = new HashMap<>();
        for (String key : words) {
            if (map.get(key) == null) {
                map.put(key, new Freq(key));
            } else {
                map.get(key).freq++;
            }
        }
        List<Freq> ret = new ArrayList<>(map.values());
        Collections.sort(ret, new Comparator<Freq>() {

            @Override
            public int compare(Freq o1, Freq o2) {
                // TODO Auto-generated method stub
                return o2.freq - o1.freq == 0 ? o1.val.compareTo(o2.val) : o2.freq - o1.freq;
            }

        });
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(ret.get(i).val);
        }
        return res;
    }
}
