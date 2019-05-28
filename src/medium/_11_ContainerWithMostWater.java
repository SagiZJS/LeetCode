package medium;

public class _11_ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;
		int max = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
		outer: while (true) {
			// possible edge must not be a valley (e.g for 3,1,2 1 is a valley)
			// search for a possible edge
			if (height[left] < height[right]) {
				// search from left to right for a height greater than height[left]
				int index = left;
				while (height[index] <= height[left]) {
					index++;
					if (index == right) {
						break outer;
					}
				}
				left = index;
				int contains = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
				if (max < contains) {
					max = contains;
				}
			} else {
				int index = right;
				while (height[index] <= height[right]) {
					index--;
					if (index == left) {
						break outer;
					}
				}
				right = index;
				int contains = (height[left] < height[right] ? height[left] : height[right]) * (right - left);
				if (max < contains) {
					max = contains;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		_11_ContainerWithMostWater s = new _11_ContainerWithMostWater();
		int[] height = {1, 8,6,2,5,4,8,3,7};
		System.out.println(s.maxArea(height));
	}
}
