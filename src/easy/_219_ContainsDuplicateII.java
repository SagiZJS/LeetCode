package easy;

import java.util.HashSet;
import java.util.Set;

public class _219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (; i < k + 1 && i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        for (; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        _219_ContainsDuplicateII s = new _219_ContainsDuplicateII();
        System.out.println(s.containsNearbyDuplicate(new int[] { -1, -1 }, 1));
    }
}
