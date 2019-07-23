package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hashs = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101 };
        List<List<String>> result = new ArrayList<>();
        long[] hashTable = new long[strs.length];
        long hash = 1;
        int count = 0;
        for (String string : strs) {
            hash = computeHash(string, hashs);
            if (count == 0) {
                hashTable[count++] = hash;
                result.add(new ArrayList<>());
                result.get(0).add(string);
            } else {
                boolean equalFlag = false;
                int i = 0;
                for (; i < count; i++) {
                    if (hashTable[i]== hash) {
                        equalFlag = true;
                        break;
                    }
                }
                if (equalFlag) {
                    result.get(i).add(string);

                } else {
                    hashTable[count++] = hash;
                    result.add(new ArrayList<>());
                    result.get(result.size() - 1).add(string);
                }
            }

        }

        return result;
    }

    public long computeHash(String string, int[] hash) {
        long res = 1;
        for (char c : string.toCharArray()) {
            res*=hash[c-'a'];
        }
        return res;
    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<Long, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            long hash = countHash(str);
//            if (!map.containsKey(hash)) {
//                map.put(hash, new ArrayList<String>());
//            }
//            map.get(hash).add(str);
//        }
//        List<List<String>> result = new ArrayList<>();
//        for (List<String> entry : map.values()) {
//            result.add(entry);
//        }
//        return result;
//    }
//
//    private long countHash(String str) {
//        long res = 1;
//        for (char ch : str.toCharArray()) {
//            res *= primes[(int) ch - 97];
//        }
//        return res;
//    }
//
//    private static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
//            83, 89, 97, 101 };

    public static void main(String[] args) {
        _49_GroupAnagrams s = new _49_GroupAnagrams();
        String[] strs = {};
        List<List<String>> result = s.groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
