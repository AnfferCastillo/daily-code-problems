package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value.
 *
 * <p>If target is not found in the array, return [-1, -1].
 *
 * <p>You must write an algorithm with O(log n) runtime complexity.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4]
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 *
 * <p>Example 3:
 *
 * <p>Input: nums = [], target = 0 Output: [-1,-1]
 */
public class FirstAndLastPos34 {

  public static void main(String[] args) {
    var test = new FirstAndLastPos34();

    System.out.println(Arrays.toString(test.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8))); //3,4
    System.out.println(Arrays.toString(test.searchRange(new int[] {5, 7, 7, 8, 8, 8, 10}, 8))); //3,5
    System.out.println(Arrays.toString(test.searchRange(new int[] {5, 7, 7, 8, 8, 8, 9, 10}, 9)));//6,6
    System.out.println(Arrays.toString(test.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6)));//-1,-1
    System.out.println(Arrays.toString(test.searchRange(new int[] {}, 0)));//-1,-1
    System.out.println(Arrays.toString(test.searchRange(new int[] {1}, 1)));//0,0
  }

  public int[] searchRange(int[] nums, int target) {
    var positions = new int[] {-1, -1};
    var i = 0;
    var position = 0;

    while (i < nums.length) {
      if (nums[i] > target) break;

      if (nums[i] == target) {
          position = positions[0] != -1 ? 1:0;
        positions[position] = i;

      }

        if ( positions[0] != -1) {
            positions[1] = i;
        }

      i++;
    }

    return positions;
  }
}
