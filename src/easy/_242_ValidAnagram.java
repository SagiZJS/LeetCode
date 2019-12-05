package easy;

public class _242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hashtable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c;
            c = s.charAt(i);
            hashtable[c - 'a']++;
            c = t.charAt(i);
            hashtable[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hashtable[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _242_ValidAnagram s = new _242_ValidAnagram();
        s.isAnagram("nl", "cx");
    }
}
