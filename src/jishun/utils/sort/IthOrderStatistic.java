package jishun.utils.sort;

public class IthOrderStatistic {
	/**using quicksort O(n)
	 * 
	 * @param nums 	arr
	 * @param low 	starting index
	 * @param high	ending index
	 * @param k 	kth order 
	 * @return 		the kth value
	 */
	
	public static int ithOrderSatistic(int[] nums, int low, int high, int k) {
		int index = QuickSort.partition(nums, low, high);
        
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 > k) {
            return ithOrderSatistic(nums, low, index - 1, k);
        } else {
            return ithOrderSatistic(nums, index + 1, high, k);
        }
	}
}
