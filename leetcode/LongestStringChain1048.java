package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * <p>wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in
 * wordA without changing the order of the other characters to make it equal to wordB.
 *
 * <p>For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad". A
 * word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a
 * predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a
 * word chain with k == 1.
 *
 * <p>Return the length of the longest possible word chain with words chosen from the given list of
 * words.
 *
 * <p>Example 1:
 *
 * <p>Input: words = ["a","b","ba","bca","bda","bdca"] Output: 4 Explanation: One of the longest
 * word chains is ["a","ba","bda","bdca"]. Example 2:
 *
 * <p>Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"] Output: 5 Explanation: All the words can
 * be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"]. Example 3:
 *
 * <p>Input: words = ["abcd","dbqca"] Output: 1 Explanation: The trivial word chain ["abcd"] is one
 * of the longest word chains. ["abcd","dbqca"] is not a valid word chain because the ordering of
 * the letters is changed.
 *
 * <p>Constraints:
 *
 * <p>1 <= words.length <= 1000 1 <= words[i].length <= 16 words[i] only consists of lowercase
 * English letters.
 */
public class LongestStringChain1048 {
  public static void main(String[] args) {
    //
    var test = new LongestStringChain1048();
    System.out.println(
        test.longestStrChain(new String[] {"a", "b", "ba", "bca", "bda", "bdca"})); // 4
    System.out.println(
        test.longestStrChain(new String[] {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})); // 5
    System.out.println(test.longestStrChain(new String[] {"abcd", "dbqca"})); // 1
  }

  public int longestStrChain(String[] words) {
    Arrays.sort(words, (a, b) -> a.length() - b.length());
    var map = new HashMap<String, Integer>();
    var max = 0;
    for (var word : words) {
      var current = map.putIfAbsent(word, 1);
      for (int i = 0; i < word.length(); i++) {
        var next = new StringBuilder(word).deleteCharAt(i).toString();
        var newCount = Math.max(map.getOrDefault(next, 0) + 1, map.get(word));
        map.put(word, newCount);
        max = newCount > max ? newCount : max;
      }
    }

    return max;
  }

  private int lscTab(String word, HashMap<String, Integer> map) {
    if (word.length() == 0) return 0;
    if (map.containsKey(word)) return map.get(word);

    var maxCount = 0;
    for (int i = 0; i < word.length(); i++) {
      var count = lscTab(word.substring(0, i) + word.substring(i + 1), map);
      maxCount = count > maxCount ? count : maxCount;
    }

    return maxCount;
  }

  private int lsc(String[] words, int index) {
    if (index >= words.length) return 0;
    var maxCount = 1;
    for (int i = index; i < words.length; i++) {
      if (isChooseable(words, i)) {
        var count = 1 + lsc(words, i + 1);
        maxCount = count > maxCount ? count : maxCount;
      }
    }
    return maxCount;
  }

  public boolean isChooseable(String[] words, int index) {
    if (index + 1 >= words.length) return false;
    if (words[index].length() > (words[index + 1].length() + 1)) return false;
    if (words[index].length() == words[index + 1].length()) return false;
    var word = words[index + 1];
    for (var i = 0; i < word.length(); i++) {
      var position = words[index].lastIndexOf(word.charAt(i));
      if (position < 0 || position < i) return false;
    }
    return true;
  }
}
