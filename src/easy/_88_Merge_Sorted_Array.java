package easy;

import java.util.Arrays;

public class _88_Merge_Sorted_Array {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0, j = 0, index = 0;
		int[] copy = new int[m];
		System.arraycopy(nums1, 0, copy, 0, m);
		while (i < m && j < n) {
			if (nums2[j] < copy[i]) {
				nums1[index++] = nums2[j++];
			} else {
				nums1[index++] = copy[i++];
			}
			System.out.println("" + i + " " + j);
		}
		while (j < n) {
			nums1[index++] = nums2[j++];
		}
		while (i < m) {
			nums1[index++] = copy[i++];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
	}

}
