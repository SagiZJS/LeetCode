package easy;

public class _14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		String lp="";
		String nlp="";
		int i=0;
		outer:while(true) {
			try{
				nlp += strs[0].charAt(i++);
			} catch(Exception e) {
				break outer;
			}
			for(String temp:strs) {
				if(!temp.startsWith(nlp)) {
					break outer;
				}
			}
			lp=nlp;
		}
		return lp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
