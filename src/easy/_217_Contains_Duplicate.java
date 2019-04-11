package easy;

import java.util.*;

public class _217_Contains_Duplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		Set<Integer> s = new HashSet<Integer>();
		for (int temp : nums) {
			if (!s.add(temp)) {
				return true;
			}
		}
		return false;

	}
}
