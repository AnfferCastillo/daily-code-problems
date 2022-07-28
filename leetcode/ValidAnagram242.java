package leetcode;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word or
 * phrase, typically using all the original letters exactly once.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "anagram", t = "nagaram" Output: true Example 2:
 *
 * <p>Input: s = "rat", t = "car" Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length, t.length <= 5 * 104 s and t consist of lowercase English letters.
 */
public class ValidAnagram242 {

  public static void main(String[] args) {
    var test = new ValidAnagram242();
    System.out.println(test.isAnagram("anagram", "nagaram"));
    System.out.println(test.isAnagram("rat", "car"));
  }

    public boolean isAnagram(String s, String t) {
        var map = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for(var c: t.toCharArray()) {
            if(!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if(map.get(c) <= 0) map.remove(c);
        }

        return map.isEmpty();
    }
}
