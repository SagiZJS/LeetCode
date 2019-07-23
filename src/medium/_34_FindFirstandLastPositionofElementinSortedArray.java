package medium;

import java.util.Arrays;

public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        while (start <= end) {
            if (nums[start] == target && nums[end] == target) {
                return new int[] { start, end };
            }
            if (start + 1 >= end && nums[start] != target && nums[end] != target) {
                break;
            }
            middle = (start + end) / 2;
            if (nums[middle] < target) {
                start = middle + 1;
            }
            if (nums[middle] > target) {
                end = middle;
            }
            if (nums[middle] == target) {
                int leftMiddle = (start + middle) / 2;
                int rightMiddle = (middle + end + 1) / 2;
                while (nums[leftMiddle] == target) {
                    if (leftMiddle == start) {
                        leftMiddle--;
                        break;
                    }
                    leftMiddle = (start + leftMiddle) / 2;
                }
                start = leftMiddle + 1;
                while (nums[rightMiddle] == target) {
                    if (rightMiddle == end) {
                        rightMiddle++;
                        break;
                    }
                    rightMiddle = (end + rightMiddle + 1) / 2;
                }
                end = rightMiddle - 1;

            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        _34_FindFirstandLastPositionofElementinSortedArray s = new _34_FindFirstandLastPositionofElementinSortedArray();
        int[] nums = { 1,4};
        int target = 4;
        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }
}
