package easy;

public class _28_Implement_strStr {
	public int strStr(String haystack, String needle) {
		int tc;
		if((tc=needle.length())==0)return 0;
		if(tc>haystack.length()) {
			return -1;
		}
		outer:for(int i =0;i<haystack.length()-tc;i++) {
			if(haystack.charAt(i)==needle.charAt(0)) {
				int bit = 0;
				while(++bit<tc) {
					if(haystack.charAt(i+bit)!=needle.charAt(bit)) {
						continue outer;
					}
				}
				return i;
			}
		}
		return -1;
//		return haystack.indexOf(needle);
	}
}
