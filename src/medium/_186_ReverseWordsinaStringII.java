package medium;

public class _186_ReverseWordsinaStringII {
    public void reverseWords(char[] s) {
        flipBetween(s, 0, s.length - 1);
        int j = 0;
        int i = 0;
        for (i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                flipBetween(s, j, i - 1);
                j = i + 1;
            }
        }
        flipBetween(s, j, i - 1);
    }

    public void flipBetween(char[] chars, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        _186_ReverseWordsinaStringII s = new _186_ReverseWordsinaStringII();
        s.reverseWords("the sky is blue".toCharArray());
    }
}
