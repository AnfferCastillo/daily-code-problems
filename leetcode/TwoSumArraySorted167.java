package leetcode;

import java.util.Arrays;

public class TwoSumArraySorted167 {

  public static void main(String[] args) {
    //

   // System.out.println(TwoSumArraySorted167.binarySearch(new int[]{2, 7, 11, 15}, 1, 0, 4));
   /* TwoSumArraySorted167.print(TwoSumArraySorted167.twoSum(new int[] {-1, 0, 2}, 1)); // [1, 3]*/
   // TwoSumArraySorted167.print(TwoSumArraySorted167.twoSum(new int[] {2, 7, 11, 15}, 9)); // [1,2]
  /* TwoSumArraySorted167.print(TwoSumArraySorted167.twoSum(new int[] {-1, 0}, -1)); //[1,2]*/
    //TwoSumArraySorted167.print(TwoSumArraySorted167.twoSum(new int[] {-1, 0}, 8)); //[0,0]*/
   /* TwoSumArraySorted167.print(TwoSumArraySorted167.twoSum(new int[] {2,3,4}, 6)); //[1,3]*/
  }

  public static int[] twoSum(int[] numbers, int target) {
    var indexes = new int[2];

    for(var i = 0; i < numbers.length; i++) {
      var remainder = target - numbers[i];
      indexes[1] = binarySearch(numbers, remainder, i + 1, numbers.length);
      if(indexes[1] != 0) {
        indexes[0] = i+1;
        break;
      }
    }

    return indexes;

  }

  private static int binarySearch(int[] numbers, int numero, int start, int end) {
    var midPoint = (end + start ) / 2;
    if(end - start < 1) return 0;

    if (numero > numbers[midPoint]) {
      return binarySearch(numbers, numero, midPoint + 1, end);
    } else if(numero < numbers[midPoint]) {
      return binarySearch(numbers, numero, start, midPoint);
    } else if (numbers[midPoint] == numero) {
     return midPoint+1;
    } else {
      return 0;
    }
  }

  public static void print(int[] a) {
    System.out.print("[");
    for (int i : a) {
      System.out.print(i + ",");
    }
    System.out.println(" ]");
  }
}
