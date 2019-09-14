package medium;

public class _151_ReverseWordsinaString {
    public String reverseWords(String s) {
        StringBuilder output = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals("")) {
                continue;
            }
            if (output.length() == 0) {
                output.append(ss[i]);
            } else  {
                output.append(' ');
                output.append(ss[i]);
            }
        }
        return output.toString();
    }
}
