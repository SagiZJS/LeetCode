package medium;

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end++;
            } else {
                res.add(formStr(start, end));
                start = nums[i];
                end = start;
            }
        }
        res.add(formStr(start, end));
        return res;
    }
    private String formStr(int start, int end) {
        if (end > start) {
            return String.format("%d->%d", start,end);
        } else if (end == start) {
            return String.valueOf(start);
        } else {
            return null;
        }
    }
}
