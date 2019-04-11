package easy;

public class _53_Maximum_Subarray {

	public int maxSubArray(int[] nums) {
		int thisSum =0,maxSum=nums.length>0?nums[0]:0;
		for(int i=0;i<nums.length;i++) {
			thisSum+=nums[i];
			if(thisSum>maxSum) {
				maxSum=thisSum;
			} 
			if(thisSum<0) {
				thisSum=0;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		
	}

}
