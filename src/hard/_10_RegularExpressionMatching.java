package hard;

public class _10_RegularExpressionMatching {
//	public boolean isMatch(String s, String p) {
//		boolean matched = true;
//		if (p.length() == 0) {
//			if (s.length() == 0) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if (s.length() == 0) {
//			// ???
//		}
//		for (int i = 0; i < p.length(); i++) {
//			if (isDigit(p.charAt(i))) {
//				if (i == p.length() - 1 || p.charAt(i + 1) != '*') {
//					// search the character and try to match then split the String and Search
//					int lastIndex = 0;
//					while ((lastIndex = s.indexOf(p.substring(i, i + 1), lastIndex)) != -1) {
//						// devide
//						String prefix = s.substring(0, lastIndex);
//						String suffix = s.substring(lastIndex + 1, s.length());
//						String preRegex = p.substring(0, i);
//						String sufRegex = p.substring(i + 1, s.length());
//						if (isMatch(prefix, preRegex) && isMatch(suffix, sufRegex)) {
//							return true;
//						}
//					}
//					return false;
//				}
//			}
//		}
//		for (int i = 0; i < p.length(); i++) {
//			if (p.charAt(i) == '.') {
//				for (int j = 0; j < s.length(); j++) {
//					// devide
//					String prefix = s.substring(0, j);
//					String suffix = s.substring(j + 1, s.length());
//					String preRegex = p.substring(0, i);
//					String sufRegex = p.substring(i + 1, s.length());
//					if (isMatch(prefix, preRegex) && isMatch(suffix, sufRegex)) {
//						return true;
//					}
//				}
//				return false;
//			}
//		}
//		for (int i = 0; i < p.length(); i++) {
//			if (isDigit(p.charAt(i))) {
//				if (p.charAt(i + 1) == '*') {
//					// search the character and try to match then split the String and Search
//					int lastIndex = 0;
//					boolean flag = false;
//					while ((lastIndex = s.indexOf(p.substring(i, i + 1), lastIndex)) != -1) {
//						// devide
//						String prefix = s.substring(0, lastIndex);
//						String suffix = s.substring(lastIndex + 1, s.length());
//						String preRegex = p.substring(0, i);
//						String sufRegex = p.substring(lastIndex + 1, s.length());
//						if (isMatch(prefix, preRegex) && isMatch(suffix, sufRegex)) {
//							return true;
//						}
//					}
//					return false;
//				}
//			}
//		}
//		return false;
//	}
//
//	private boolean isCharacter(char c) {
//		if (c >= 'a' && c <= 'z') {
//			return true;
//		}
//		if (c >= 'A' && c <= 'Z') {
//			return true;
//		}
//		return false;
//	}

	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			if (s.length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		if (s.length() == 0) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (p.charAt(j) == '*') {
					j--;
				} else {
					return false;
				}
			}
			return true;
		}
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[s.length()][p.length()] = true;
		for (int j = p.length() - 1; j >= 0; j--) {
			if (p.charAt(j) == '*') {
				match[s.length()][--j] = true;
			} else {
				break;
			}
		}
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = p.length() - 1; j >= 0; j--) {
				if (p.charAt(j) == '*') {
					j--;
					int index = i;
					if (p.charAt(j) == '.') {
						while (index <= s.length()) {
							if (match[index][j + 2]) {
								match[i][j] = true;
								break;
							}
							index++;
						}
					} else {
						boolean flag = false;
						while (index < s.length() && s.charAt(index) == p.charAt(j)) {
							flag = flag || match[index][j + 2];
							index++;
						}
						flag = flag || match[index][j + 2];
						match[i][j] = flag;
					}
				} else {
					if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
						match[i][j] = true && match[i + 1][j + 1];
					}
				}
			}
		}
		return match[0][0];
	}
//	public boolean isMatch(String s, String p) {
//		boolean[][] match = new boolean[s.length()][p.length()];
//		if (p.length() == 0) {
//			if (s.length() == 0) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if (isCharacter(p.charAt(0))) {
//			if (p.length() > 1 && p.charAt(1) == '*') {
//				// X* detect if the first few char is X and recursion
//				int index = 0;
//				while (index < s.length() && s.charAt(index) == p.charAt(0)) {
//					if (isMatch(s.substring(index), p.substring(2))) {
//						return true;
//					}
//					index++;
//				}
//				if (isMatch(s.substring(index), p.substring(2))) {
//					return true;
//				}
//				return false;
//			} else {
//				// X 
//				if (s.length() == 0) {
//					// s = "" then doesn't match
//					return false;
//				}
//				// compare if the first char match if match go on with the rest (recursion)
//				return s.charAt(0) == p.charAt(0) ? isMatch(s.substring(1, s.length()), p.substring(1, p.length()))
//						: false;
//			}
//		}
//		if (p.length() > 1 && p.charAt(1) == '*') {
//			// .*
//			int index = 0;
//			while (index < s.length()) {
//				if (isMatch(s.substring(index), p.substring(2))) {
//					return true;
//				}
//				index++;
//			}
//			if (isMatch(s.substring(index), p.substring(2))) {
//				return true;
//			}
//			return false;
//		} else {
//			// .
//			if (s.length() == 0) {
//				return false;
//			}
//			return isMatch(s.substring(1), p.substring(1));
//		}
//	}

	public static void main(String[] args) {
		_10_RegularExpressionMatching s = new _10_RegularExpressionMatching();
		
		
		System.out.println(s.isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"));
	}
}
