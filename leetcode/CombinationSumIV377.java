package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of distinct integers nums and a target integer target, return the number of
 * possible combinations that add up to target.
 *
 * <p>The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,3], target = 4 Output: 7
 *
 * Explanation: The possible combination ways are:
 * (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1) Note that different sequences are
 * counted as different combinations.
 *
 * <p></p>Example 2:
 *
 * <p>Input: nums = [9], target = 3 Output: 0
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 200 1 <= nums[i] <= 1000 All the elements of nums are unique. 1 <= target
 * <= 1000
 */
public class CombinationSumIV377 {

  public static void main(String[] args) {
    var test = new CombinationSumIV377();
    System.out.println(test.combinationSum4(new int[]{1,2,3}, 4)); //7
  }

    public int combinationSum4(int[] nums, int target) {
        var count = combinationSum4(nums, target, new HashMap<Integer, Integer>());
        return count;
    }

    private int combinationSum4(int[] nums, int target, Map<Integer, Integer> map) {
        if(map.containsKey(target)) return map.get(target);
        if(target == 0) return 1;
        if(target < 0) return 0;

        var count = 0;
        for(var num : nums) {
            count += combinationSum4(nums, target -num, map);
        }

        map.put(target, count);
        return count;
    }

}
