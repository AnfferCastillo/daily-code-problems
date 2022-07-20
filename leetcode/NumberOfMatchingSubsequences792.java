package leetcode;

import java.util.*;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a
 * subsequence of s.
 *
 * <p>A subsequence of a string is a new string generated from the original string with some
 * characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * <p>For example, "ace" is a subsequence of "abcde".
 *
 * <p>Example 1:
 *
 * <p>Input: s = "abcde", words = ["a","bb","acd","ace"] Output: 3 Explanation: There are three
 * strings in words that are a subsequence of s: "a", "acd", "ace". Example 2:
 *
 * <p>Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"] Output: 2
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 5 * 104 1 <= words.length <= 5000 1 <= words[i].length <= 50 s and words[i]
 * consist of only lowercase English letters.
 */
public class NumberOfMatchingSubsequences792 {

  public static void main(String[] args) {
    var test = new NumberOfMatchingSubsequences792();
    System.out.println(test.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
      System.out.println(test.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
  }

    public int numMatchingSubseq(String s, String[] words) {
        var count = 0;
        var table = new HashMap<Character, List<Integer>>();

        for(var i = 0; i < s.length(); i++) {
            var c =s.charAt(i);
            table.putIfAbsent(c, new ArrayList<>());
            table.get(c).add(i);
        }


        for(var word: words) {
            var j = 0;
            var position= -1;

            while(j < word.length()) {
                if(table.containsKey(word.charAt(j))){
                    var positions = table.get(word.charAt(j));
                    var i = 0;
                    while(i < positions.size() && positions.get(i) <= position) {
                        i++;
                    }
                    if(i < positions.size()) position = positions.get(i);
                    else break;
                } else {
                    break;
                }
                j++;
            }
            if(j == word.length()) count++;
        }
        return count;
    }

}
