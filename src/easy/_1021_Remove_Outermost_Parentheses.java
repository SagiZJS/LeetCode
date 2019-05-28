package easy;

public class _1021_Remove_Outermost_Parentheses {
	public String removeOuterParentheses(String S) {
		if (S == null || S.length() == 0)
			return S;
		int counter = 0;

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				if (counter++ != 0) {
					s.append(S.charAt(i));
				}
			}
			if (S.charAt(i) == ')') {
				if (--counter != 0) {
					s.append(S.charAt(i));
				}
			}
		}
		return s.toString();
	}
}
