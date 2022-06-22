package leetcode;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
 * that each unique element appears only once. The relative order of the elements should be kept the
 * same.
 *
 * <p>Since it is impossible to change the length of the array in some languages, you must instead
 * have the result be placed in the first part of the array nums. More formally, if there are k
 * elements after removing the duplicates, then the first k elements of nums should hold the final
 * result. It does not matter what you leave beyond the first k elements.
 *
 * <p>Return k after placing the final result in the first k slots of nums.
 *
 * <p>Do not allocate extra space for another array. You must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 3 * 104 -100 <= nums[i] <= 100 nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromArray26 {

  public static void main(String[] args) {
    var test = new RemoveDuplicatesFromArray26();
    System.out.println(test.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4})); // 5
    System.out.println(test.removeDuplicates(new int[] {1, 1, 2})); // 2
    System.out.println(test.removeDuplicates(new int[] {1})); // 1
    System.out.println(test.removeDuplicates(new int[] {1, 2})); // 2
    System.out.println(test.removeDuplicates(new int[] {1, 2, 3, 4, 5, 6, 7})); // 7
  }

  private int removeDuplicates(int[] nums) {
    var i = 0;
    var j = 1;
    var lowest = 101;
    while (i < nums.length && j < nums.length) {
      var current = nums[i];
      if (j < nums.length && nums[j] == current) {
        nums[j] = lowest;
        j++;
      } else if (current == lowest) {
        nums[i] = nums[j];
      } else {
        i++;
      }

      if (i == j) j++;
      if (j >= nums.length) return i + 1;
    }

    return 1;
  }
}
