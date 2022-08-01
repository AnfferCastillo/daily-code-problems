package leetcode;

import java.util.HashMap;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e.,
 * grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The
 * robot can only move either down or right at any point in time.
 *
 * <p>Given the two integers m and n, return the number of possible unique paths that the robot can
 * take to reach the bottom-right corner.
 *
 * <p>The test cases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * <p>Example 1:
 *
 * <p>Input: m = 3, n = 7 Output: 28
 *
 * Example 2:
 *
 * <p>Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there are a total of 3
 * ways to reach the bottom-right corner: 1. Right -> Down -> Down 2. Down -> Down -> Right 3. Down
 * -> Right -> Down
 */
public class UniquePaths62 {

  public static void main(String[] args) {
    var test = new UniquePaths62();
    System.out.println(test.uniquePaths(3,2)); //2
    System.out.println(test.uniquePaths(3,7)); //28
  }

    public int uniquePaths(int m, int n) {


        var matrix = new int[m+1][n+1];

        matrix[1][1] = 1;

        for(var i = 0; i <= m; i++) {
            for(var j=0; j <= n; j++) {
                if(j!= n && i != m) {
                    matrix[i+1][j] += matrix[i][j];
                    matrix[i][j+1] += matrix[i][j];
                } else if(i == m && j != n) {
                    matrix[i][j+1] += matrix[i][j];
                } else if(j == n && i!=m) {
                    matrix[i+1][j] += matrix[i][j];
                }
            }
        }

        return matrix[m][n];
//
//        var count = 0;
//
//        count = uniquePaths(0,0, m,n, new HashMap<String, Integer>());
//
//        return count;
    }

    private int uniquePaths(int colum, int row, int m, int n, HashMap<String, Integer> memo) {
        var key = row + "_" + colum;
        if(memo.containsKey(key)) return memo.get(key);
        var colInBound = 0 <= colum && colum < m;
        var rowInBound = 0 <= row && row < n;

        if(colum == m-1 && row == n -1) return 1;
        if(!colInBound) return  0;
        if(!rowInBound) return 0;

        var count = uniquePaths(colum+1, row, m,n,memo) + uniquePaths(colum, row+1, m, n, memo);
        memo.put(key, count);
        return memo.get(key);
    }

}
