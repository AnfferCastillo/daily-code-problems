package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Your are recording your dice rolls on paper but after a while you lost some of the records. Now
 * you have the whole information about the dice rolls you recorded, the number of the unknown dice
 * rolls and the average of the total of dice rolls.
 *
 * <p>Given an array of known dice rolls (A) and the number of unknown dice rolls (F), and the
 * average of all dice rolls (K) find a possible combination for the unknown dice rolls.
 *
 * <p>Example:
 *
 * <p>A = [1,2,3] F = 5 K = 4
 *
 * <p>There are two possible results: [6,6,6,5,3], [6,6,6,4,4], [6,6,6,6,2]
 *
 * <p>Example 2:</p>
 *
 * <p></p>
 */
public class DiceRolls {

  private static int[] DICE = new int[] {6, 5, 4, 3, 2, 1};

  public static void main(String[] args) {
    var test = new DiceRolls();
    var com = test.findPossibleCombinations(new int[] {1, 2, 3}, 5, 4);
    System.out.println(Arrays.toString(com)); //[6,6,6,5,3], [6,6,6,4,4], [6,6,6,6,2]
    System.out.println(Arrays.toString(test.findPossibleCombinations(new int[] {6,4,5}, 2, 4)));//[2,3] [3,2] [4,1]
    System.out.println(Arrays.toString(test.findPossibleCombinations(new int[] {6,4,4}, 2, 4)));//[2,4] [3,3] [5,1]
  }

  public int[] findPossibleCombinations(int[] A, int F, int K) {
    /* We need to find a combination, an array, right?
     * We know that the total amount of dice rolls is equal to A.length + F (total of recorded dice rolls + total of unknown dice rolls)
     * We also know what the average of all dice rolls is, right?
     * So we need to know what the sum of unknown dice rolls is for us to be able to find a combination of dice rolls which sum up to that number. right?
     * That being said, We can propose the following equation:
     *
     * K = (Sum(A) + Sum(Unknown dice rolls))/ (A.length + F)
     *
     * This will give us the value of "Sum(Unknown dice rolls)" , lets call it target.
     * Now we need to find a combination of length F of dice rolls (values from 1-6) that sum up to target.
     */

    // we have our target
    var target = (K * (A.length + F)) - Arrays.stream(A).reduce(0, Integer::sum);

    // now we find our possible combination
    var combinations = findCombinations(target, F, new int[F], 0, new HashMap<Integer, Integer>());

    return combinations;
  }

  private int[] findCombinations(
      int target, int length, int[] combination, int index, Map<Integer, Integer> memo) {

    if (target < 0 && index < length) {
      combination[index] = 0;
      return null;
    }

    if (target == 0 && combination.length == length && combination[length-1] != 0) {
      return combination;
    }

    if (index >= length) {
      combination[combination.length - 1] = 0;
      return null;
    }
    for (var num : DICE) {
      var reminder = target - num;
      combination[index] = num;
      var founded  = findCombinations(reminder, length, combination, index + 1, memo);
      if(founded != null) return founded;
    }

    return null;
  }
}
