package medium;

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int[] nums = new int[4];
        recursion(4, s, nums, result);
        return result;
    }

    public void recursion(int left, String s, int[] nums, List<String> result) {
        if (left == 0) {
            if (s.length() == 0) {
                result.add(String.format("%d.%d.%d.%d", nums[0], nums[1], nums[2], nums[3]));
            }
            return;
        }
        if (s.length() < left) {
            return;
        }
        if (s.length() > left * 3) {
            return;
        }
        int num = 0;
        num = Integer.valueOf(s.substring(0, 1));
        nums[4 - left] = num;
        recursion(left - 1, s.substring(1), nums, result);
        if (num != 0 && s.length() >= 2) {

            num = Integer.valueOf(s.substring(0, 2));
            nums[4 - left] = num;
            recursion(left - 1, s.substring(2), nums, result);
            if (s.length() >= 3) {
                num = Integer.valueOf(s.substring(0, 3));
                if (num <= 255) {
                    nums[4 - left] = num;
                    recursion(left - 1, s.substring(3), nums, result);
                }
            }
        }
    }
}
