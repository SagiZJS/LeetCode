package amazon;

public class _866PrimePalindrome {

    public int primePalindrome(int N) {
        String n = Integer.toString(N);

        int root = 0;
        if (N >= 10) {
            root = Integer.valueOf(n.substring(0, n.length() / 2));
        } else {
            root = 1;
        }
        int odd;
        while (true) {
            odd = oddPalindrome(root);
            if (odd >= N && isPrime(odd)) {
                break;
            }
            root++;
        }
        // if (N >= 10) {
        //     root = Integer.valueOf(n.substring(0, n.length() / 2));
        // } else {
        //     root = 1;
        // }
        // int even;
        // while (true) {
        //     even = evenPalindrome(root);
        //     if (even >= N && isPrime(even)) {
        //         break;
        //     }
        //     root++;
        // }
        if (odd>11 && 11>=N) {
            return 11;
        }
        return  odd ;
    }

    private int oddPalindrome(int val) {
        String s = Integer.toString(val);
        StringBuilder b = new StringBuilder();
        b.append(s);
        for (int i = s.length() - 2; i >= 0; i--) {
            b.append(s.charAt(i));
        }
        return Integer.valueOf(b.toString());
    }

//    private int evenPalindrome(int val) {
//        String s = Integer.toString(val);
//        StringBuilder b = new StringBuilder();
//        b.append(s);
//        for (int i = s.length() - 1; i >= 0; i--) {
//            b.append(s.charAt(i));
//        }
//        return Integer.valueOf(b.toString());
//    }

    private boolean isPrime(int val) {
        if (val == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(val) + 1 && i < val; i++) {
            if (val % i == 0) {
                // System.out.println(""+val+"false " + i+"*"+(val/i));
                return false;
            }
        }
        return true;
    }
    
}
