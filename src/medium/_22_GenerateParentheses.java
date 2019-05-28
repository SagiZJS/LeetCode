package medium;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
//	public List<String> generateParenthesis(int n) {
//		List<List<String>> res = new ArrayList<>();
//		List<String> list = new ArrayList<>();
//		list.add("()");
//		res.add(list);
//		for (int i = 2; i <= n; i++) {
//			list = new ArrayList<>();
//			for (String string : res.get(i - 1 - 1)) {
//				list.add("(" + string + ")");
//			}
//			for (int j = 1; j < i; j++) {
//				for (String prefix : res.get(i - j - 1)) {
//					for (String suffix : res.get(j - 1)) {
//						if (list.contains(prefix+suffix)) {
//							continue;
//						}
//						list.add(prefix + suffix);
//					}
//				}
//			}
//			res.add(list);
//		}
//		return res.get(n - 1);
//	}
	private List<String> res = new ArrayList<>();
	
	public List<String> generateParenthesis(int n) {
		int count = 0;
		recursion("", 0, 0, n);
		return res;
	}
	
	private void recursion(String string, int open, int close, int max) {
		if (string.length() == max*2) {
			res.add(string);
			return;
		}
		if (open < max) {
			recursion(string+"(", open+1, close, max);
		}
		if (close < max && close <= open) {
			recursion(string+")", open, close+1, max);
		}
	}
	

	public static void main(String[] args) {
		_22_GenerateParentheses s = new _22_GenerateParentheses();
		s.res.add("1");
		s= new _22_GenerateParentheses();
		System.out.println(s.res.contains("1"));
	}
}
