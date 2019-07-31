package easy;

public class _67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        boolean forward = false;

        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        while (count <= b.length()) {
            boolean n1 = a.charAt(a.length() - count) == '1';
            boolean n2 = b.charAt(b.length() - count) == '1';
            boolean sum = n1 ^ n2 ^ forward;
            forward = (n1 && n2) || ((n1 || n2) && forward);
            result.insert(0, sum ? '1' : '0');
            count++;
        }
        while (count <= a.length()) {
            boolean n1 = a.charAt(a.length() - count) == '1';
            boolean sum = n1 ^ forward;
            forward = n1 && forward;
            result.insert(0, sum ? '1' : '0');
            count++;
        }
        if (forward) {
            result.insert(0, '1');
        }
        return result.toString();
    }
}
