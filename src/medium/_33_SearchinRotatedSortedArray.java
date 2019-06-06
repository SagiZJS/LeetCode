package medium;

import java.util.Random;

public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        int index = (high + low) / 2;
        if (nums[index] == target)
            return index;
        // reduce
        while (nums[low] > nums[high]) {
            if (nums[index] == target) return index;
            if (target >= nums[low]) {
                
                if (nums[index] <= target) {
                    if (nums[index] > nums[low]) {
                        low = index+1;
                    } else {
                        high = index-1;
                    }
                } else {
                    high = index - 1;
                }
            } else {
                
                if (nums[index] > target) {
                    if (nums[index] < nums[high]) {
                        high = index-1;
                    } else {
                        low = index+1;
                    }
                } else {
                    low = index + 1;
                }
            }
            index = (high + low) / 2;
            if (low > high) return -1;
        }
        // BS
        while (low <= high) {
            index = (high + low) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        int index = (high + low) / 2;
        if (nums[index] == target)
            return index;
        if (nums[low] > nums[high]) {

            if (target <= nums[high]) {
                // reduce to BS
                if (target > nums[index]) {
                    low = index + 1;
                } else {
                    if (nums[index] > nums[high]) {
                        low = index;
                    } else {
                        high = index;
                    }
                    index = (high + low) / 2;
                    while (low <= high) {
                        if (low + 1 >= high) {
                            if (nums[low] == target)
                                return low;
                            if (nums[high] == target)
                                return high;
                            break;
                        }
                        if (nums[index] == target)
                            return index;
                        if (nums[index] > nums[high]) {
                            low = index;
                            index = (low + high) / 2;

                            continue;
                        }
                        if (nums[index] < nums[low]) {
                            if (nums[index] < target) {
                                low = index + 1;
                                break;
                            } else {
                                high = index;
                                index = (low + high) / 2;
                            }
                        } else {
                            low = index;
                            index = (low + high) / 2;
                        }
                    }
                }
            } else if (target >= nums[0]) {
                // reduce to BS
                if (target < nums[index]) {
                    high = index - 1;
                } else {
                    if (nums[index] < nums[0]) {
                        high = index;
                    } else {
                        low = index;
                    }
                    index = (high + low) / 2;
                    while (low <= high) {
                        if (low + 1 >= high) {
                            if (nums[low] == target)
                                return low;
                            if (nums[high] == target)
                                return high;
                            break;
                        }
                        if (nums[index] == target)
                            return index;
                        if (nums[index] < nums[low]) {
                            high = index;
                            index = (low + high) / 2;
                            continue;
                        }
                        if (nums[index] > nums[high]) {
                            if (nums[index] > target) {
                                high = index;
                                break;
                            } else {
                                low = index;
                                index = (low + high) / 2;
                            }
                        } else {
                            high = index - 1;
                            index = (low + high) / 2;
                        }
                    }
                }
            }
        }
        while (low <= high) {
            index = (high + low) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
        // Binary Search
        return -1;
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
        _33_SearchinRotatedSortedArray s = new _33_SearchinRotatedSortedArray();
        Random random = new Random();
        int[] nums = _33_SearchinRotatedSortedArray.arrayCreater(3, 6);
//        nums = new int[] { 3,1 };
        int target = -1;
        target = 2;
        System.out.println(s.search(nums, target));
        System.out.println(_33_SearchinRotatedSortedArray.searchBF(nums, target));
        while (true) {
            int middle =1+ random.nextInt(100);
            int end = middle + 1+random.nextInt(100);
            System.out.println(""+middle+end);
            nums = _33_SearchinRotatedSortedArray.arrayCreater(middle, end);
            for (int i = 1; i < nums.length; i++) {
                target = i;
                if (!(s.search(nums, target) == _33_SearchinRotatedSortedArray.searchBF(nums, target))) {
                    System.out.println(String.format("\nin array(%d, %d) test %d failed", middle, end, target));
                } else {
                    System.out.println("p");
                }
            }
        }
    }
}
