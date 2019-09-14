package medium;

import java.util.TreeSet;


public class _220_ContainsDuplicateIII {
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        List<Long> currentNums = new ArrayList<>();
//        int i = 0;
//        for (; i < k + 1 && i < nums.length; i++) {
//            if (checkRange(nums[i], currentNums, t)) {
//                return true;
//            }
//            currentNums.add((long)nums[i]);
//        }
//        for (; i < nums.length;i++) {
//            currentNums.remove(0);
//            if (checkRange(nums[i], currentNums, t)) {
//                return true;
//            }
//            currentNums.add((long)nums[i]);
//        }
//        return false;
//
//    }
//    private boolean checkRange(long val, List<Long> currentNums, int t) {
//        for(long i: currentNums) {
//            if (i - val<=t &&i-val >= -t) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        _220_ContainsDuplicateIII s = new _220_ContainsDuplicateIII();
        System.out.println(s.containsNearbyAlmostDuplicate(new int[] {2147483647,-2147483647},
                1,
                2147483647));
    }
}
