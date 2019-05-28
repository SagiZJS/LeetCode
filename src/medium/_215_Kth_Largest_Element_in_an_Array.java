package medium;

public class _215_Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    
    private int quickSort(int[] nums, int low, int high, int k) {
        int index = partition(nums, low, high);
        
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 > k) {
            return quickSort(nums, low, index - 1, k);
        } else {
            return quickSort(nums, index + 1, high, k);
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        if (low > high) {
            return -1;
        }
        int pivot = nums[high];
        int i = low-1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;
        return i;
    }
    
    public static void main(String[] args) {
    	_215_Kth_Largest_Element_in_an_Array s = new _215_Kth_Largest_Element_in_an_Array();
    	int[] nums = {1,3,2,4,5,10,7,8,9,6};
    	int k = 9;
    	System.out.println(s.findKthLargest(nums, k));
    }
}
