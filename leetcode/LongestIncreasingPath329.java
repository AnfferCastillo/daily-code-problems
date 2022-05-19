package leetcode;

import java.util.*;

public class LongestIncreasingPath329 {

  public static void main(String[] args) {
    var test = new LongestIncreasingPath329();
    var matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
    System.out.println(test.longestIncreasingPAth(matrix));

    var matrix2 = new int[][] {{1,2}};
    System.out.println(test.longestIncreasingPAth(matrix2));

    var matrix3 = new int[][] {
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
            {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
            {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
            {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
            {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
            {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
            {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
            {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
            {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
            {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
            {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
            {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    System.out.println(test.longestIncreasingPAth(matrix3));
  }

    public int longestIncreasingPAth(int[][] matrix) {
        var biggestPath = 0;
        int [][] pathsMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j= 0; j < matrix[i].length; j++) {
                pathsMatrix[i][j] = 1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        HashMap<String, Integer> paths = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                var currentPath = 0;
                for (var dir : directions) {
                    var row = i + dir[0];
                    var col = j + dir[1];

                    var rowInBound = 0 <= row && row < matrix.length;
                    var colInBound = 0 <= col && col < matrix[i].length;
                    if(!rowInBound || !colInBound) continue;
                    if(matrix[row][col] <= matrix[i][j]) continue;

                    if(pathsMatrix[i][j] + pathsMatrix[row][col] > currentPath) currentPath = pathsMatrix[i][j] + pathsMatrix[row][col];

                }

               if(currentPath != 0) pathsMatrix[i][j] = currentPath;
               if(pathsMatrix[i][j] > biggestPath) biggestPath = pathsMatrix[i][j];
            }
        }

        return biggestPath;
    }
}

/**
 * var biggestPath = 0; Queue<int[]> queue = new LinkedList<>(); int[][] directions = {{-1,0},
 * {0,1}, {1,0}, {0,-1}}; for (int i = 0; i < matrix.length; i++) { for (int j = 0; j <
 * matrix[i].length; j++) { queue.add(new int[]{i, j, 1});
 *
 * <p>while(!queue.isEmpty()) { var current = queue.poll(); var foundAnotherStep = false; for (var
 * dir : directions) { var row = current[0] + dir[0]; var col = current[1] + dir[1]; var rowInBound
 * = 0 <= row && row < matrix.length; var colInBound = 0 <= col && col < matrix[current[0]].length;
 *
 * <p>if(!rowInBound || !colInBound) continue; if(matrix[row][col] <=
 * matrix[current[0]][current[1]]) continue;
 *
 * <p>foundAnotherStep = true; queue.add(new int[]{row, col, current[2] + 1}); }
 *
 * <p>if(!foundAnotherStep) { if(current[2] > biggestPath) biggestPath = current[2]; } }
 *
 * <p>} }
 *
 * <p>return biggestPath;
 */
