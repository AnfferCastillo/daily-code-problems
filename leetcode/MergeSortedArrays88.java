package leetcode;

import java.util.Arrays;

public class MergeSortedArrays88 {

    /*
    [1,2,3,0,0,0]
3
[2,5,6]
3
     */

  public static void main(String[] args) {

    MergeSortedArrays88.merge(new int []{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
  }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    var i = 0;


    for (i = m ; i < nums1.length; i++) {
      nums1[i] = nums2[i - m];
    }

    Arrays.sort(nums1);
        }
}
