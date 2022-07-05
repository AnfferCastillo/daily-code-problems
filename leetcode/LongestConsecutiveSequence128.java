package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence128 {

  public static void main(String[] args) {
    var test =  new LongestConsecutiveSequence128();
    System.out.println(
    test.longestConsecutive(new int[]{100, 4,200,1,3,2}));
  }

    public int longestConsecutive(int[] nums) {
        var max = 0;

        var set = new HashSet<Integer>();

        for (var n : nums) {
            set.add(n);
        }

        for (var n : nums) {
            var count = 0;
            if(!set.contains( n - 1)) {
                while(set.contains(n + count)) {
                    count++;
                }
            }

            max = count > max ? count : max;
        }

        return max;
    }
}
