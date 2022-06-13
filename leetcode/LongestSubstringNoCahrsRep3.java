package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringNoCahrsRep3 {

  public static void main(String[] args) {
    var test = new LongestSubstringNoCahrsRep3();

    System.out.println(test.lengthOfLongestSubstring("abcabcbb")); //3
    System.out.println(test.lengthOfLongestSubstring("bbbbb"));//1
    System.out.println(test.lengthOfLongestSubstring("pwwkew"));//3
  }

    public int lengthOfLongestSubstring(String s) {

        var maxCount = 0;
        var charCount = new HashSet<Character>();
        var subsTring = "";
        for(var i = 0; i < s.length(); i++) {
            if(charCount.add(s.charAt(i))) {

            } else {

            }

           /* var count = 1;
            var j = i+1;
            var charCount = new HashSet<Character>();
            charCount.add(s.charAt(i));
            while(j < s.length()  && charCount.add(s.charAt(j))) {
                j++;
                count++;
            }

            if(count > maxCount) maxCount = count;

            if(j == s.length()) {
                return maxCount;
            }*/
        }

        return maxCount;
    }
}
