package leetcode;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and
 * grid[i][j] = 0 represents water.
 *
 * <p>Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
 * surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * <p>The island doesn't have "lakes", meaning the water inside isn't connected to the water around
 * the island. One cell is a square with side length 1. The grid is rectangular, width and height
 * don't exceed 100. Determine the perimeter of the island.
 *
 * <p>Input: grid = [[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]
 *
 * <p>Output: 16 Explanation: The perimeter is the 16 yellow stripes in the image above.
 */
public class IslandPerimeter463 {

  public static void main(String[] args) {
    var test = new IslandPerimeter463();
    System.out.println(
        test.islandPerimeter(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
  }

  public int islandPerimeter(int[][] grid) {
    var perimeter = 0;
    var directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    for (var i = 0; i < grid.length; i++) {
      for (var j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          continue;
        }

        for (var dir : directions) {
          var row = i + dir[0];
          var col = j + dir[1];
          var inBoundRow = row >= 0 && row < grid.length;
          var inBoundCol = col >= 0 && col < grid[i].length;

          if (inBoundCol && inBoundRow && grid[row][col] == 0) {
            perimeter++;
          } else if (!inBoundCol || !inBoundRow) {
            perimeter++;
          }
        }
      }
    }

    return perimeter;
  }
}
