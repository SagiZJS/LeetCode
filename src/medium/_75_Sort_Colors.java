package medium;

public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2 && p1 < nums.length; i++) {
            while (nums[i] != 1 && i >= p1 && i <= p2) {
                if (nums[i] == 0) {
                    if (i == p1) {
                        p1++;
                        break;
                    }
                    swap(nums, p1++, i);
                }
                if (nums[i] == 2) {
                    if (i == p2) {
                        p2--;
                        break;
                    }
                    swap(nums, p2--, i);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _75_Sort_Colors s = new _75_Sort_Colors();
        s.sortColors(new int[] {2});
    }
}
