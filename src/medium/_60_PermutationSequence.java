package medium;

public class _60_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[n];
        int[] counts = new int[n];
        counts[0] = 1;
        int index = n - 2;
        int digit = 0;

        for (int i = 1; i < n; i++) {
            counts[i] = counts[i - 1] * (1 + i);
        }

        while (index >= 0) {
            digit = 0;
            while (used[digit]) {
                digit++;
            }
            while (k > counts[index]) {
                digit++;
                while (used[digit]) {
                    digit++;
                }
                k -= counts[index];
            }
            used[digit] = true;
            result.append(digit + 1);
            index--;
        }
        digit = 0;
        while (used[digit]) {
            digit++;
        }
        result.append(digit + 1);
        return result.toString();
    }

    public static void main(String[] args) {
        _60_PermutationSequence s = new _60_PermutationSequence();
        System.out.println(s.getPermutation(4, 9));
    }
}
