package medium;

public class _962_MaximumWidthRamp {

	public int maxWidthRamp(int[] A) {
		int len = A.length;
		int[] position = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			position[i] = i;
		}
		quickSort(A, 0, A.length - 1, position);
		for (int i = 0; i < len - 1; i++) {
			position[i] = position[i + 1] - position[i];
		}
		int sum = 0;
		int max = 0;
		for (int i = 0; i < len - 1; i++) {
			sum += position[i];
			if (max < sum) {
				max = sum;
			}
			if (sum <= 0) {
				sum = 0;
			}
		}
		return max;
	}

	public static void quickSort(int[] nums, int low, int high, int[] nums2) {

		int index = partition(nums, low, high, nums2);

		if (index == -1)
			return;

		quickSort(nums, low, index - 1, nums2);

		quickSort(nums, index + 1, high, nums2);

	}

	public static int partition(int[] nums, int low, int high, int[] nums2) {
		if (low == high) {
			return low;
		}
		if (low > high) {
			return -1;
		}
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (nums[j] <= pivot) {
				i++;
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
				swap(nums, i, j);
				swap(nums2, i, j);
			}
		}
		i++;
////        int temp = nums[i];
//        nums[i] = nums[high];
//        nums[high] = temp;
		swap(nums, i, high);
		swap(nums2, i, high);
		return i;
	}

	public static void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		_962_MaximumWidthRamp t = new _962_MaximumWidthRamp();
		int[] A = { 2,2,1 };
		System.out.println(t.maxWidthRamp(A));
	}
}
