package easy;

public class _27_Remove_Element {

	public int removeElement(int[] nums, int val) {
		outer:for(int i=0;i<nums.length;i++) {
			if(nums[i]==val) {
				for(int j=i+1;j<nums.length;j++) {
					if(nums[j]!=val) {
						//swap
						int temp =nums[j];
						nums[j]=nums[i];
						nums[i]=temp;
						continue outer;
					}
				}
				return i;
			}
		}
		return nums.length;
	}

	public static void main(String[] args) {

	}

}
