package easy;

import java.util.Arrays;

public class _204_CountPrimes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 0;

        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count = 0;
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; i * j < n; j++) {

                primes[i * j] = false;
            }
        }

        for (int i = 0; i < primes.length; i++) {
            if (primes[i] == true)
                count++;
        }

        return count;
    }

}
