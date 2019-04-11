package easy;

public class _771_Jewels_and_Stones {
	int Solution(String J, String S) {
		int count = 0;
		for (int i = 0; i < J.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (J.charAt(i) == S.charAt(j)) {
					count++;
				}
			}
		}
		return count;
	}
}
