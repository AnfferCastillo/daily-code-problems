package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumMovestoEqualArrayElementsII462 {
  public static void main(String[] args) {
    var test = new MinimumMovestoEqualArrayElementsII462();
    System.out.println(test.minMoves2(new int[] {1, 2, 3})); // 2
    System.out.println(test.minMoves2(new int[] {1, 10, 2, 9})); // 16
    System.out.println(test.minMoves2(new int[] {1, 0, 0, 8, 6})); // 14*/
    System.out.println(test.minMoves2(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));//2127271182
  }

  public int minMoves2(int[] nums) {
    if (nums.length == 1) return 0;
    Arrays.sort(nums);

    var midPoint = nums.length / 2;
    var median = 0;
    if( nums.length % 2 != 0) {
       median = nums[midPoint];
    } else {
      median = (nums[midPoint] + nums[midPoint -1])/2;
    }

    var aux = 0;
    for (var n : nums) {
      var max = Math.max(n, median);
      var min = Math.min(n, median);
      aux += max -min;
    }

    return aux;
  }
}
