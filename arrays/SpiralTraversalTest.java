package arrays;

public class SpiralTraversalTest {

    public static void main(String[] args) {
        var subject = new SpiralTraversal();

        System.out.println("Tests Iterative Approach");
        /*// Test case 1 - Square Matrix
        var expected1 = "12348121615141395671110";
        var actual1 = subject.iterativeTrasversal(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        assertEquals(expected1, actual1);

        // Test case 2 - Non-Square Matrix
        var expected2 = "123698745";
        var actual2 = subject.iterativeTrasversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertEquals(expected2, actual2);

        // Test Case 3 - Empty Array
        var expected3 = "";
        var actual3 = subject.iterativeTrasversal(new int[][]{});
        assertEquals(expected3, actual3);

        // Test case 4 - One row array
        var expected4 = "12345";
        var actual4 = subject.iterativeTrasversal(new int[][]{{1,2,3,4,5}});
        assertEquals(expected4, actual4);

        // Test case 5 - One column array
        var expected5 = "12345";
        var actual5 = subject.iterativeTrasversal(new int[][]{{1}, {2}, {3}, {4}, {5}});
        assertEquals(expected5, actual5);*/


        var expectedB = "147896325";
//        var actualB = subject.iterativeTrasversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
//        assertEquals(expectedB, actualB);

        var actualC= subject.recursiveTraversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertEquals(expectedB, actualC);
/*
        System.out.println("===========================================================");
        System.out.println("Test recursive approach");

        // Test case 6 - Square Matrix
        var actual6 = subject.recursiveTraversal(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        assertEquals(expected1, actual6);

        // Test case 7 - Non-Square Matrix
        var actual7 = subject.recursiveTraversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertEquals(expected2, actual7);

        // Test Case 8 - Empty Array
        var actual8 = subject.recursiveTraversal(new int[][]{});
        assertEquals(expected3, actual8);

        // Test case 9 - One row array
        var actual9 = subject.recursiveTraversal(new int[][]{{1,2,3,4,5}});
        assertEquals(expected4, actual9);

        // Test case 10 - One column array
        var actual10 = subject.recursiveTraversal(new int[][]{{1}, {2}, {3}, {4}, {5}});
        assertEquals(expected5, actual10);
*/


    }

    private static void assertEquals(String expected, String actual) {
        if(!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected: %s but Actual: %s ---- FAILED!", expected, actual));
        } else {
            System.out.println(String.format("Expected: %s - Actual: %s ---- PASS!", expected, actual));
        }
    }


}

/**
 * 2D array traversal spiral
 */
class SpiralTraversal {
    public static final String RIGHT = "RIGHT";
    public static final String LEFT = "LEFT";
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";

    public static final int[][] DIRECTIONS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    /**
     * Wrapper function for validations and initial call to the actual traversal (explore).
     * @param arr
     * @return String representation of the path
     */
    public String recursiveTraversal(int[][] arr) {
        if(arr == null || arr.length == 0 || arr[0].length == 0) return "";
        var test = new int[-200];
        return traversal(arr, 0, 0, DIRECTIONS[0], 0, new boolean[arr.length][arr[0].length],"");
    }

    /**
     * REcursive approach
     * Time complexity: O(MxN) being M the array rows and N the array cols.
     * Space complexity: O(MxN) because we will have a call stack of MxN.
     * @return
     */
    public String traversal(int[][] arr, int row, int col, int[] direction, int directionIndex, boolean[][] visited, String stringPath) {
        // first check if we are in bounds
        var rowInBound = row < arr.length && row >= 0;
        var colInBound = col < arr[0].length && col >= 0;
        if(!rowInBound || !colInBound) return stringPath;

        // check visited matrix to avoid inifinte loops
        if(visited[row][col]) return stringPath;

        // concatenate the integer to the path
        stringPath += arr[row][col];
        // mark as visited to prevent infinite loops
        visited[row][col] = true;

        stringPath = traversal(arr, row + direction[0], col + direction[1], direction, directionIndex, visited, stringPath);
        var newIndex = (directionIndex + 1) % 4;
        var newDirection = DIRECTIONS[newIndex];
        stringPath = traversal(arr, row + newDirection[0], col + newDirection[1], newDirection, newIndex, visited, stringPath);
        /*// Traverse the matrix using a "DFS" approach
        if(RIGHT.equals(direction)) {
            stringPath = traversal(arr, row, col+1, direction, visited, stringPath);
            stringPath = traversal(arr, row+1, col, UP, visited, stringPath);
        }else if(LEFT.equals(direction)) {
            stringPath = traversal(arr, row, col-1, direction, visited, stringPath);
            stringPath = traversal(arr, row-1, col, DOWN, visited, stringPath);
        }else if(DOWN.equals(direction)) {
            stringPath = traversal(arr, row+1, col, direction, visited, stringPath);
            stringPath = traversal(arr, row, col-1, RIGHT, visited, stringPath);
        } else if(UP.equals(direction)) {
            stringPath = traversal(arr, row-1, col, direction, visited, stringPath);
            stringPath = traversal(arr, row, col+1, LEFT, visited,stringPath);
        }*/
        return stringPath;
    }

    /**
     * Iterative approach
     * Time complexity: O(MxN)
     * Space complexity: O(1) we just have this call and the space for the array
     *
     * @param arr
     * @return
     */
    public String iterativeTrasversal(int[][] arr) {
        //checking for null or empty
        if(arr == null || arr.length == 0 || arr[0].length == 0) return "";

        var col = 0;
        var row = 0;
        var visited = new boolean[arr.length][arr[0].length];
        var direction = 0;
        // directions right, down, left, and up.
        var directions = new int[][]{{1,0},{0,1},{-1,0}, {0,-1}};
        var stringPath = "";

        for(var i = 0; i < arr.length * arr[0].length; i++) {
            stringPath += arr[row][col];
            visited[row][col] = true;
            var step = directions[direction];

            // check if we need a direction change
            var rowInBound = row + step[0] < arr.length && row + step[0] >= 0;
            var colInBound = col + step[1] < arr[0].length && col + step[1] >= 0;
            if(!rowInBound || !colInBound || visited[row + step[0]][col + step[1]]) {
                //get the right direction
                direction = (direction + 1) % 4;
                step = directions[direction];
            }

            //moving a step in the grid
            row += step[0];
            col += step[1];

        }

        return stringPath;
    }
}