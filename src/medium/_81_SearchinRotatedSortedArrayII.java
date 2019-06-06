package medium;

import java.util.Arrays;

public class _81_SearchinRotatedSortedArrayII {
   
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length - 1;
        int index = (high + low) / 2;
        if (nums[index] == target)
            return true;
        
        while (nums[low] >= nums[high]) {
            if (nums[index] == target) return true;
            if (target >= nums[low]) {
                
                if (nums[index] <= target) {
                    if (nums[index] > nums[low]) {
                        low = index+1;
                    } else if (nums[index] > nums[low]){
                        high = index-1;
                    } else {
                        return search(Arrays.copyOfRange(nums, low, index),target) || search(Arrays.copyOfRange(nums, index, high) ,target);
                    }
                } else {
                    high = index - 1;
                }
            } else {
                
                if (nums[index] > target) {
                    if (nums[index] < nums[high]) {
                        high = index-1;
                    } else if (nums[index] > nums[high]){
                        low = index+1;
                    } else {
                        return search(Arrays.copyOfRange(nums, low, index),target) || search(Arrays.copyOfRange(nums, index, high) ,target);
                    }
                } else {
                    low = index + 1;
                }
            }
            index = (high + low) / 2;
            if (low > high) return false;
        }
        // BS
        while (low <= high) {
            index = (high + low) / 2;
            if (nums[index] == target) {
                return true;
            } else if (nums[index] < target) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        return false;
    }
    
    public static int[] arrayCreater(int middle, int end) {
        int[] output = new int[end];
        int count = 0;
        for (int i = middle; i <= end; i++) {
            output[count++] = i;
        }
        for (int i = 1; i < middle; i++) {
            output[count++] = i;
        }
        return output;
    }

    public static int searchBF(int[] nums, int target) {
        int index = 0;
        while (nums[index] != target) {
            index++;
        }
        return index;
    }


    public static void main(String[] args) {
        _81_SearchinRotatedSortedArrayII s = new _81_SearchinRotatedSortedArrayII();
        int[] nums = _33_SearchinRotatedSortedArray.arrayCreater(3, 6);
        nums = new int[] { 1,1,3,1 };
        int target = -1;
        target = 3;
        System.out.println(s.search(nums, target));
//        System.out.println(_33_SearchinRotatedSortedArray.searchBF(nums, target));
//        while (true) {
//            int middle =1+ random.nextInt(100);
//            int end = middle + 1+random.nextInt(100);
//            System.out.println(""+middle+end);
//            nums = _33_SearchinRotatedSortedArray.arrayCreater(middle, end);
//            for (int i = 1; i < nums.length; i++) {
//                target = i;
//                if (!(s.search(nums, target) == _33_SearchinRotatedSortedArray.searchBF(nums, target))) {
//                    System.out.println(String.format("\nin array(%d, %d) test %d failed", middle, end, target));
//                } else {
//                    System.out.println("p");
//                }
//            }
//        }
    }
}
