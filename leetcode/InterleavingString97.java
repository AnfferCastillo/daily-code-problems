package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * <p>An interleaving of two strings s and t is a configuration where they are divided into
 * non-empty substrings such that:
 *
 * <p>s = s1 + s2 + ... + sn t = t1 + t2 + ... + tm |n - m| <= 1 The interleaving is s1 + t1 + s2 +
 * t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ... Note: a + b is the concatenation of
 * strings a and b.
 *
 * <p>Example 1:
 *
 * <p>Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true
 *
 * <p>Example 2:
 *
 * <p>Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false
 */
public class InterleavingString97 {

  public static void main(String[] args) {
    var test = new InterleavingString97();
    System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
    System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    System.out.println(test.isInterleave("", "", "")); // true
    System.out.println(test.isInterleave("aa",
    "ab",
    "aaba"));

  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if("".equals(s1) && "".equals(s2) && "".equals(s3)) return true;

    var i1 = 0;
    var i2 = 0;
    var i3 = 0;

    while(i1 < s1.length() && i3 < s3.length() && s3.charAt(i3) == s1.charAt(i1)) {
      i1++;
      i3++;
    }

    while(i2 < s2.length() && i3 < s3.length() && s3.charAt(i3) == s2.charAt(i2)) {
      i2++;
      i3++;
    }

    if((i1 == 0 && s1.length() > 0) || (i2 == 0 && s2.length() > 0) || (i3 == 0 && s3.length() > 0)) {
      return false;
    } else {
      return isInterleave(s1.substring(i1), s2.substring(i2), s3.substring(i3));
    }

  }

/*  public boolean canConstruct(String target, ArrayList<String> A, int index) {
    if (target == "") return true;

    for (var i = index; i < A.size(); i++ ) {
      // if is a suffix
      var word = A.get(i);
      var size = word.length();
      if (target.substring(0, size).equals(word)) {
        var itCan = canConstruct(target.substring(word.length()), A, i+1);
        if (itCan) return true;
      }
    }
    return false;
  }*/
}
