package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ZeroesAndOnes474 {

    public static void main(String[] args) {
        var test = new ZeroesAndOnes474();

       System.out.println(test.findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3)); //4

        System.out.println(test.findMaxForm(new String[]{"10","0","1"}, 1,1));//2

        System.out.println(test.findMaxForm(new String[]{"0","11","1000","01","0","101","1","1","1",
                "0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000",
                "0","11101","1","0","10","0111"}, 9, 80)); //17
    }

    public int findMaxForm(String[] strs, int m, int n) {
        var memo = new HashMap<String, Integer>();
        //return lookSubset(strs, m, n, 0, memo);
        return lookSubset2(strs, m, n, 0, new Integer[strs.length][m+1][n+1]);
    }


    public int lookSubset2(String[] strs, int targetZeroes, int targetOnes, int index, Integer[][][] memo) {
        if (targetZeroes < 0 || targetOnes < 0)
            return 0;
        if (index >= strs.length)
            return 0;


        if(memo[index][targetZeroes][targetOnes] != null) return  memo[index][targetZeroes][targetOnes];

        var counters = countZeroesAndOne(strs[index]);
        var remainderZeroes = targetZeroes - counters[0];
        var remainderOnes = targetOnes - counters[1];
        var take = 0;

        if(remainderZeroes >=  0 && remainderOnes >= 0)
             take = 1 + lookSubset2(strs, remainderZeroes, remainderOnes, index + 1, memo);

        var reject = lookSubset2(strs, targetZeroes, targetOnes, index + 1, memo);

        memo[index][targetZeroes][targetOnes]= Math.max(take, reject);
        return memo[index][targetZeroes][targetOnes];
    }


    public int lookSubset(String[] strs, int targetZeroes, int targetOnes, int index, Map<String, int[]> memo) {
        if (targetZeroes <= 0 && targetOnes <= 0)
            return 0;
        if (index >= strs.length)
            return 0;
        var maxCount = 0;
        for (int i = index; i < strs.length; i++) {
            var count = 0;
            var counters = countZeroesAndOne(strs[i]);
            var remainderZeroes = targetZeroes - counters[0];
            var remainderOnes = targetOnes - counters[1];
            if(remainderOnes >= 0 && remainderZeroes >= 0) count = 1;

            count += lookSubset(strs, remainderZeroes, remainderOnes, i + 1, memo);
            if(count > maxCount) maxCount = count;
        }

        return maxCount;
    }

    public int[] countZeroesAndOne(String str) {

        var zeoresAndOnes = new int[] { 0, 0 };
        for (char c : str.toCharArray()) {
            if (c == '0')
                zeoresAndOnes[0]++;
            else
                zeoresAndOnes[1]++;
        }
        return zeoresAndOnes;
    }
}
