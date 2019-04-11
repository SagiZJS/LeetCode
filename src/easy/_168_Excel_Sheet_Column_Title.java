package easy;

import java.util.*;

public class _168_Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
		n=n-1;
		Stack<Integer> s = new Stack<Integer>();
		while (n / 26 != 0) {
			s.push(n % 26);
			n = n / 26;
		}
		s.push(n%26);
		char A = 'A';
		String temp = "";
		while (!s.isEmpty()) {
			temp = temp + (char) (A + s.pop());
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_168_Excel_Sheet_Column_Title t = new _168_Excel_Sheet_Column_Title();
		System.out.println(t.convertToTitle(28));
	}

}
