package leetcode;

/***
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * Constraints:
 * 1 <= n <= 30
 *
 * 333355522
 * count = 2
 * auxResult = "433522"
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        var test = new CountAndSay38();
        System.out.println(test.countAndSay(6));
        System.out.println(test.countAndSay(4));
        System.out.println(test.countAndSay(1));
    }

    public String countAndSay(int n) {
        var result = "1";

        for(var i = 2; i <= n; i++) {
            var auxResult = "";
            var j = 0;
            var k = 1;
            var count = 1;
            while(j  < result.length()) {

                if(k == result.length()) {
                    auxResult += String.valueOf(count) + result.charAt(j);
                    break;
                }

                if(result.charAt(j) == result.charAt(k)) {
                    count++;
                }else {
                    auxResult += String.valueOf(count)+result.charAt(j);
                    count = 1;
                }
                j++;
                k++;
            }
            result = auxResult;
        }

        return result;
    }
}

