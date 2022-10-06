package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
public class FindKClosestElements658 {

    public static void main(String[] args) {
        var test = new FindKClosestElements658();
        System.out.println(test.findClosestElements(new int[]{1,2,3,4,5}, 4,3));// 1234
        System.out.println(test.findClosestElements(new int[]{1,2,3,4,5}, 4,-1));// 1234
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find an insertion point
        // start spreading out and collect values

        var result = new ArrayList<Integer>();
        var right = binarySearch(arr, 0, arr.length, x);
        var left = right - 1;

        while(result.size() < k){
            var rightInBound = right >= 0 && right < arr.length;
            var leftInBound = left >= 0 && left < arr.length;

            if(!leftInBound && rightInBound) {
                result.add(arr[right]);
                right++;
            }else if(!rightInBound && leftInBound) {
                result.add(arr[left]);
                left--;
            } else {
                var mod = Math.abs(arr[left] - x) - Math.abs(arr[right] - x);
                if(mod <= 0) {
                    result.add(arr[left]);
                    left--;
                } else if(mod > 0) {
                    result.add(arr[right]);
                    right++;
                }
            }

        }
        result.sort(Integer::compareTo);

        return result;
    }

    public int binarySearch(int[] arr, int start, int end, int value) {
        if(end - start < 1) return end;

        var mid = (start + end) / 2;

        if(arr[mid] == value) {
            return mid;
        } else if(arr[mid] > value) {
            return binarySearch(arr, start, mid, value);
        } else if(arr[mid] < value) {
            return binarySearch(arr, mid+1, end, value);
        }

        return 0;
    }
}
