package jishun.utils.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] nums, int low, int high) {
		
        int index = partition(nums, low, high);
        
        if (index == -1) return;
        
        quickSort(nums, low, index - 1);
      
        quickSort(nums, index + 1, high);

    }
	
	public static int partition(int[] nums, int low, int high) {
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
		int[] A = {12,6,1,5,4,1,5,8,4,53,458,6,89,413,1,58,48,12333};
		quickSort(A, 0, A.length - 1);
		System.out.println(Arrays.toString(A));
	}
}
