package easy;

public class _35_Search_Insert_Position {
	public int searchInsert(int[] nums, int target) {
		int i = 0,j =nums.length-1;
		while(i<=j) {
			if(target>nums[(i+j)/2]) {
				if((i+j)/2==j) {
					return j+1;
				}
				i=(i+j+1)/2;
			} else if(target<nums[(i+j)/2]) {
				if((i+j)/2==i) {
					return i;
				}
				j=(i+j)/2;
			} else {
				return (i+j)/2;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

	}

}
