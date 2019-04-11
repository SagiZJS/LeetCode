package easy;

public class _58_Length_of_Last_Word {
	public static int lengthOfLastWord(String s) {
		String[] words = s.split(" ");

		int output=words.length >0 
				? words[words.length - 1].length() 
						: 0;
		return output;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" "));
	}
}
