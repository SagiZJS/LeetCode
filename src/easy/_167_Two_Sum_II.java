package easy;

public class _167_Two_Sum_II {
	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = 1;
		while (true) {
			if (numbers[i] + numbers[j] < target) {
				if (j == numbers.length - 1 || numbers[i] + numbers[j + 1] > target) {
					i++;
					j = i + 1;
				} else {
					j++;
				}
			} else if (numbers[i] + numbers[j] == target) {
				int[] output = new int[2];
				output[0] = i + 1;
				output[1] = j + 1;
				return output;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
