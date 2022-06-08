package leetcode;

import java.util.Stack;

public class RemovePalindromeSubsequences1332 {

  public static void main(String[] args) {
    System.out.println(removePalindromeSub("ababa"));
      System.out.println(removePalindromeSub("abb"));
    System.out.println(removePalindromeSub("baabb"));
    System.out.println(removePalindromeSub(""));
  }

    public static int removePalindromeSub(String s) {
        if(s.isBlank() || s.isEmpty()) {
            return 0;
        } else if(isPalindrome(s)){
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean isPalindrome(String s) {
        var backward = "";
        for(int i = s.length()-1; i >= 0; i--) {
            backward += s.charAt(i);
        }

        return backward.equals(s);
    }
}
