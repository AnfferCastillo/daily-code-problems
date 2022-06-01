package leetcode;

import java.util.Arrays;

public class RunningSum1480 {

  public static void main(String[] args) {
    var test = new RunningSum1480();

    test.print(test.runningSum(new int[] {1, 2, 3, 4})); //[1,3,6,10]
    test.print(test.runningSum(new int[]{1,1,1,1,1})); //[1,2,3,4,5]
    test.print(test.runningSum(new int[]{3,1,2,10,1})); //[3,4,6,16,17]
  }

  public int[] runningSum(int[] nums) {
    var sumArray = new int[nums.length];
    var sum = nums[0]; // nums.length is always >= 1
    sumArray[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum += nums[i];
      sumArray[i] = sum;
    }

    return sumArray;
  }

  public void print(int[] nums) {
    System.out.print("{");
    for (var num : nums) {
      System.out.print(num + " ");
    }
    System.out.print("}");
    System.out.println();
  }
}
