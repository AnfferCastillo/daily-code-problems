package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static leetcode.RemovePalindromeSubsequences1332.isPalindrome;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "babad" Output: "bab" Explanation: "aba" is also a valid answer. Example 2:
 *
 * <p>Input: s = "cbbd" Output: "bb"
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 1000 s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring5 {
  public static void main(String[] args) {
    //
    var test = new LongestPalindromicSubstring5();
    System.out.println(test.longestPalindrome("babad")); // bab
    System.out.println(test.longestPalindrome("cbbd")); // bb
    System.out.println(test.longestPalindrome("ac")); // a or c
    System.out.println(test.longestPalindrome("a")); // a
    System.out.println(test.longestPalindrome("bbbbbb")); // bbbbbb
    System.out.println(test.longestPalindrome("aacabdkacaa")); // aca
  }

  public String longestPalindrome(String s) {
    var longest = "";

    if(s.length() < 2 ) return s;

    var max = 0;
    for(var i = 0; i < s.length(); i++) {
      var oneCenter = explorePalindromeRange(s, i, i);
      var twoCenters = explorePalindromeRange(s, i, i+1);
      var maxLength = oneCenter[0] > twoCenters[0] ? oneCenter: twoCenters;

      if(maxLength[0] > max) {
        max = maxLength[0];
        longest = s.substring(maxLength[1], maxLength[2]);
      }

    }



   /* var mid = s.length() / 2;
    var seed = s.charAt(mid) + "";
    longest = explorePalindrome(s, seed, mid - 1, mid + 1, new HashMap<>());
*/
    return longest;
  }

  public int[] explorePalindromeRange(String word, int left, int right) {
    var L = left;
    var R = right;
    while(L >= 0 && R < word.length() && word.charAt(L) == word.charAt(R)) {
      L--;
      R++;
    }

    return new int[]{R - L - 1, L+1, R};
  }

  public String explorePalindrome(
      String word, String current, int indexLeft, int indexRight, Map<String, String> map) {
    if (map.containsKey(current)) return map.get(current);

    var max = "";
    if (isPalindrome(current)) {
      max = current;
      map.put(current, current);
    }

    if (indexLeft >= 0) {
      var left =
          explorePalindrome(word, word.charAt(indexLeft) + current, indexLeft - 1, indexRight, map);
      max = left.length() > max.length() ? left : max;
    }

    if (indexRight < word.length()) {
      var right =
          explorePalindrome(
              word, current + word.charAt(indexRight), indexLeft, indexRight + 1, map);
      max = right.length() > max.length() ? right : max;
    }

    if (indexLeft >= 0 && indexRight < word.length()) {
      var both =
          explorePalindrome(
              word,
              word.charAt(indexLeft) + current + word.charAt(indexRight),
              indexLeft - 1,
              indexRight + 1,
              map);
      max = both.length() > max.length() ? both : max;
    }

    return max;
  }

  public static boolean isPalindrome(String s) {
    var backward = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      backward += s.charAt(i);
    }
    return backward.equals(s);
  }
}
