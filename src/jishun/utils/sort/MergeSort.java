package jishun.utils.sort;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] nums, int low, int high) {
		if (low >= high) return;
		mergeSort(nums, low, (high + low) / 2);
		mergeSort(nums, (high + low) / 2 + 1, high);
		int[] combine = new int[high - low + 1];
		int left = low;
		int right = (low + high) / 2 + 1;
		
		for (int i = 0; i < combine.length; i++) {
			if (left == (low + high) / 2 + 1) { 
				combine[i] = nums[right++];
				continue;
			}
			if (right == high + 1) {
				combine[i] = nums[left++];
				continue;
			}
			if (nums[left] > nums[right]) {
				combine[i] = nums[right++];
			} else {
				combine[i] = nums[left++];
			}
		}
		System.arraycopy(combine, 0, nums, low, combine.length);
	}
	
	public static void main(String[] args) {
		int[] nums = {5,4,1,3,2,6};
		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
