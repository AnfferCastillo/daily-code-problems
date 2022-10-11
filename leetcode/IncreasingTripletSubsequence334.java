package leetcode;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * Example 2:
 *
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * Example 3:
 *
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -2^31 <= nums[i] <= 2^(31 - 1)
 */
public class IncreasingTripletSubsequence334 {

    public static void main(String[] args) {
        var test = new IncreasingTripletSubsequence334();
        System.out.println(test.increasingTriplet(new int[]{1,2,3,4,5})); //true
        System.out.println(test.increasingTriplet(new int[]{5,4,3,2,1})); //false
        System.out.println(test.increasingTriplet(new int[]{2,1,5,0,4,6})); //true

    }

    public boolean increasingTriplet(int[] nums) {
        var min = -1;
        var med = -1;
        for(var i = 0; i < nums.length; i++) {
            if(min == -1 || nums[i] < nums[min]) {
              min = i;
            } else if( nums[i] > nums[min] && (med == -1 || nums[i] < nums[med])) {
                med = i;
            } else if(med !=-1 && nums[i] > nums[med]) {
                return true;
            }
        }
        return false;
    }
}
