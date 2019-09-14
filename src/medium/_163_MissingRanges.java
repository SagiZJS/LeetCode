package medium;

import java.util.ArrayList;
import java.util.List;

public class _163_MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long start = lower;
        long end = lower;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (start == nums[i]) {
                start = (long)nums[i];
                start++;
                continue;
            }
            end = nums[i] - 1;
            if (start <= end) {
                result.add(rangeToString(start, end));
            }
            start =(long) nums[i];
            start++;
            
        }
        if (start <= upper) {
            result.add(rangeToString(start, upper));
        }
        return result;
    }

    public String rangeToString(long start, long end) {
        if (start == end) {
            return String.format("%d", start);
        } else {
            return String.format("%d->%d", start, end);
        }
    }
}
