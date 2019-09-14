package easy;

public class _157_ReadNCharactersGivenRead4 {
    public int read4(char[] buf) {
        return 4;
    }

    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int count = 0;
        int len = 0;
        while (count < n) {
            len = read4(buf4);
            if (count + len <= n) {
                for (int i = 0; i < len; i++) {
                    buf[count ++] = buf4[i];
                }
            } else {
                for (int i = 0; i < len && count + i < n;i++) {
                    buf[count++] = buf4[i];
                }
            }
            if (len < 4) {
                break;
            }
        }
        return count;
    }
}
