package medium;

public class _80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        int tailPointer = 0;
        boolean duplicate = false;
        if (nums.length < 3) {
            return nums.length;
        }
        int lastNum = nums[0];
        length++;
        tailPointer++;
        while (tailPointer < nums.length) {
            if (nums[tailPointer] == lastNum) {
                if (duplicate) {
                    lastNum = nums[tailPointer];
                    while (tailPointer < nums.length && nums[tailPointer] == lastNum) {
                        tailPointer++;

                    }
                    if (tailPointer >= nums.length) {
                        return length;
                    }
                    if (tailPointer == nums.length - 1) {
                        swap(nums, tailPointer, length++);
                        return length;
                    }
                    lastNum = nums[tailPointer];
                    swap(nums, tailPointer++, length++);
                    duplicate = false;
                } else {
                    duplicate = true;
                    lastNum = nums[tailPointer];
                    swap(nums, tailPointer++, length++);
                }
            } else {
                duplicate = false;
                lastNum = nums[tailPointer];
                swap(nums, tailPointer++, length++);
            }
        }
        return length;
    }

    public void swap(int[] nums, int p1, int p2) {
        if (p1 == p2) {
            return;
        }
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, };
        _80_RemoveDuplicatesfromSortedArrayII s = new _80_RemoveDuplicatesfromSortedArrayII();
        s.removeDuplicates(nums);
    }
}
