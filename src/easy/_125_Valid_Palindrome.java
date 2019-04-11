package easy;

public class _125_Valid_Palindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (!(s.charAt(i) >= '0' && s.charAt(i) <= '9') && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					&& i + 1 < s.length()) {
				i++;
			}
			while (!(s.charAt(j) >= '0' && s.charAt(j) <= '9') && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
					&& j > 0) {
				j--;
			}
			if (i <= j) {
				if (s.charAt(i++) != s.charAt(j--)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println('a' > 'z');
	}

}
