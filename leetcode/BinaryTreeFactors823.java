package leetcode;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 *
 * <p>We make a binary tree using these integers, and each number may be used for any number of
 * times. Each non-leaf node's value should be equal to the product of the values of its children.
 *
 * <p>Return the number of binary trees we can make. The answer may be too large so return the
 * answer modulo 109 + 7.
 *
 * <p>Example 1:
 *
 * <p>Input: arr = [2,4] Output: 3 Explanation: We can make these trees: [2], [4], [4, 2, 2] Example
 * 2:
 *
 * <p>Input: arr = [2,4,5,10] Output: 7 Explanation: We can make these trees: [2], [4], [5], [10],
 * [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *
 * <p>Constraints:
 *
 * <p>1 <= arr.length <= 1000 2 <= arr[i] <= 109 All the values of arr are unique.
 */
public class BinaryTreeFactors823 {

  public static void main(String[] args) {
    var test = new BinaryTreeFactors823();
    System.out.println(test.numFactoredBinaryTrees(new int[]{18,3,6,2}));
  }

  public int numFactoredBinaryTrees(int[] arr) {
    var count = 0;
    for(var num : arr) {
        count += trees(arr, num);
    }
    return count;
  }

  public int trees(int[] arr, int root) {
    if (root == 1) return 1;
    var count = 0;
    for (var num : arr) {
      if (root % num == 0) {
        count += trees(arr, root / num);
      }
    }
      return count;
  }
}
