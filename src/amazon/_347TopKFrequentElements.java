package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _347TopKFrequentElements {
    private static class Freq {
        int val;
        int freq;

        public Freq(int val) {
            super();
            this.val = val;
            freq = 1;
        }

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        HashMap<Integer, Freq> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], new Freq(nums[i]));
            } else {
                map.get(nums[i]).freq++;
            }
        }
        List<Freq> freqs = new ArrayList<>();
        freqs.addAll(map.values());
        Collections.sort(freqs, new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                // TODO Auto-generated method stub
                return o2.freq - o1.freq;
            }
        });
        for (int i = 0; i < k; i++) {
            ret.add(freqs.get(i).val);
        }
        return ret;
    }
}
