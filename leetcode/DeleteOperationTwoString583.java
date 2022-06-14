package leetcode;

/*
Delete Operation Two Strings

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.



Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4

Reference: https://www.youtube.com/watch?v=ASoaQq66foQ
 */

public class DeleteOperationTwoString583 {

  public static void main(String[] args) {
      var test = new DeleteOperationTwoString583();
/*
     System.out.println(test.minDistance("sea", "eat")); //2
     System.out.println(test.minDistance("leetcode", "etco")); //4
      System.out.println(test.minDistance("ate", "sea")); //4*/
      System.out.println(test.minDistance("a", "a")); //4
  }

    public int minDistance(String word1, String word2) {
        var longest = lsc(word1, word2);

        return (word1.length() - longest) + (word2.length() - longest);
    }

    public int lsc(String word1, String word2) {
      if(word1.length() == 0 || word2.length() == 0) return 0;

      if(word1.charAt(word1.length()-1) == word2.charAt(word2.length()-1)) {
          return 1 + lsc(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
      } else {
          return Math.max(lsc(word1.substring(0, word1.length() - 1), word2), lsc(word1, word2.substring(0, word2.length() - 1)));
      }

    }

    public int lscTab(String word1, String  word2) {
      var table = new int[word2.length() + 1][word1.length() + 1];

      table[0][0] = 0;

      for(var i = 1; i < table.length; i++) {
          for(var j = 1; j < table[i].length; j++) {
                if(word2.charAt(i-1) != word1.charAt(j-1)) {
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
                } else {
                    table[i][j] = 1 + table[i-1][j-1];
                }
          }
      }

      return table[word2.length()][word1.length()];
    }
}
