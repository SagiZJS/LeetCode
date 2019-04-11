package easy;

public class _9_Palindrome_Number {
	public boolean isPalindrome(int x) {
		char[] num = String.valueOf(x).toCharArray();
		int  l =num.length;
		boolean flag=true;
		for(int i=0; i<l/2;i++) {
			if(num[i]!=num[l-1-i]) {
				flag = false;
				break;
			}
		}

		return flag;
	}

	public static void main(String[] args) {
	}

}
