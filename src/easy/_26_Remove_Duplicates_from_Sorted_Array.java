package easy;

import java.util.Arrays;

public class _26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
		int temp;
		int len = 0;
		if (nums.length > 0) {
			len++;
			for(int i=0;i<nums.length;i++) {
				if(nums[i]>nums[len-1]) {
					temp=nums[i];
					nums[i]=nums[len];
					nums[len]=temp;
					len++;
				}
			}
		}
		return len;
	}
//	public static int removeDuplicates(int[] nums) {
//		int out=0,
//				temp;
//		if(nums.length>0) {
//			temp=nums[0];
//		} else {
//			return 0;
//		}
//		for(int i=0;i<nums.length;i++) {
//			if(nums[i]>temp) {
//				temp=nums[i];
//				out++;
//			}
//		}
//		return out;
//	}
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
}
