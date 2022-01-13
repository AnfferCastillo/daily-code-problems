import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of integers, find the longest subarray where the absolute
 * difference between any two elements is less than or equal to 1.
 * 
 * Example
 * 
 * a = [1,1,2,2,4,4,5,5,5]
 * 
 * There are two subarrays meeting the criterion: [1,1,2,2] and [4,4,5,5,5] .
 * The maximum length subarray has 5 elements.
 * 
 * Function Description
 * pickingNumbers has the following parameter(s):
 * int a[n]: an array of integers
 * Returns
 * int: the length of the longest subarray that meets the criterion
 */
public class PickingNumbers {

    public static int maxSize(List<Integer> s, int index, int value, List<Integer> subSet) {
        if(index >= s.size()) {
            return index;
        }

        if(Math.abs(value - s.get(index)) <= 1){
            subSet.add(s.get(index));
            maxSize(s, index + 1, value, subSet);
        } 
            return index;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        var maxSize = 0;

        // Hold each value and ocurrences
        a.sort((i,j) -> i-j);

        var i = 0;

        // i = 1
        while(i < a.size()) {
            var subSet = new ArrayList<Integer>();
            subSet.add(a.get(i));
            i = maxSize(a, i+1, a.get(i), subSet);

            if(maxSize < subSet.size()) 
                maxSize = subSet.size();
            
        }
       

        return maxSize;
    }

    public static void main(String[] args) {

        
      // var a =  pickingNumbers(Arrays.asList(new Integer[] { 1, 1, 2, 2, 4, 4, 5, 5, 5 }));
      // var a = pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1));
        //var a  = pickingNumbers(Arrays.asList(4,5,5,5, 5, 3, 3, 1));
        var a = pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2));
       System.out.println(a);
    }

}