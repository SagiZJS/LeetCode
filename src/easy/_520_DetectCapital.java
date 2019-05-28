package easy;

public class _520_DetectCapital {
	public boolean detectCapitalUse(String word) {
		if (word == null || word.length() == 0)
			return true;
		if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
			int i = 1;
			if (word.length() == 1) {
                return true;
            }
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				i++;
				while (i < word.length()) {
					if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
						return false;
					}
					i++;

				}
				return true;
			}
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				i++;
				while (i < word.length()) {
					if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
						return false;
					}
					i++;

				}
				return true;
			}
			return false;
		} else {
			int i = 0;
			while (i < word.length()) {
				if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
					return false;
				}
				i++;
			}
			return true;
		}

	}
	public static void main(String[] args) {
		_520_DetectCapital s = new _520_DetectCapital();
		String word = "Leetcode";
		System.out.println(s.detectCapitalUse(word));
	}
}
