package easy;

public class _136_Single_Number {
	public int singleNumber(int[] nums) {
		int num = 0;
		for (int temp : nums) {
			num ^= temp;
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
