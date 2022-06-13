package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle120 {

  public static void main(String[] args) {
      var test = new Triangle120();
    System.out.println(test.minimumTotal(List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3)))); //11
      System.out.println(test.minimumTotal(List.of(List.of(-10)))); //-10
  }

    public int minimumTotal(List<List<Integer>> triangle) {
        return explore(triangle, 0, 0, new HashMap<>());
    }


    public static int explore(List<List<Integer>> triangle, int row, int index, Map<String, Integer> memo) {
        if(row >=  triangle.size()) return 0;
        var key = row + "-" + index;
        if(memo.containsKey(key)) return memo.get(key);

        var left = triangle.get(row).get(index);
        var right = triangle.get(row).get(index);

        left += explore(triangle, row + 1, index, memo);
        right += explore(triangle, row + 1, index + 1, memo);

        memo.put(key, Math.min(left, right));
        return memo.get(key);
    }

}
