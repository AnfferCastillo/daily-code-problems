package leetcode;

import java.math.BigInteger;
import java.util.HashMap;

/***
 * Given an integer n, return the decimal value of the binary string formed by concatenating
 * the binary representations of 1 to n in order, modulo 109 + 7.
 * Example 1:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: "1" in binary corresponds to the decimal value 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 27
 * Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
 * After concatenating them, we have "11011", which corresponds to the decimal value 27.
 * Example 3:
 *
 * Input: n = 12
 * Output: 505379714
 * Explanation: The concatenation results in "1101110010111011110001001101010111100".
 * The decimal value of that is 118505380540.
 * After modulo 109 + 7, the result is 505379714.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 */
public class ConcatenationOfBinaryNumbers1680 {

    public static void main(String[] args) {
        var test = new ConcatenationOfBinaryNumbers1680();
        Util.assertEquals(27, test.concatenatedBinary(3));
        Util.assertEquals(505379714, test.concatenatedBinary(12));
    }

    public int concatenatedBinary(int n) {
        var result = 1L;
        var binaryBits = new HashMap<Integer, Integer>();
        binaryBits.put(1,1);
        binaryBits.put(2,2);
        binaryBits.put(3,2);

        for(var i = 2; i<= n; i++) {
            var power = getBinaryBits(i, binaryBits);
            result = (result * ((long) Math.pow(2d, Double.valueOf(power))) + i) % ((long) Math.pow(10,9) + 7);
        }

        return (int) result;
    }

    private int getBinaryBits(int i, HashMap<Integer, Integer> binaryBits) {
        if(binaryBits.containsKey(i)) {
            return binaryBits.get(i);
        }

        var reminder = i;
        var counter = 0;

        while(reminder >= 2) {
            if (binaryBits.containsKey(reminder)) {
                var numberOfBits = counter + binaryBits.get(reminder);
                binaryBits.put(i, numberOfBits);
                return numberOfBits;
            }
            reminder = reminder / 2;
            counter++;
        }

        binaryBits.put(i, counter);
        return counter;
    }
}
