package arrays;

/**
 * Traverse a 2D array as the following pattern:
 * <p>
 * 1  2  3  4  5  6
 * 7  8  9  10 11 12
 * 13 14 15 16 17 18
 * 19 20 21 22 23 24
 * 25 26 27 28 29 30
 * 31 32 33 34 35 36
 */
public class Traverse2DArrayRainbowStyle {

    public static void main(String[] args) {
        var test = new Traverse2DArrayRainbowStyle();
        test.traverse(new int[][]{
                {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}});
        //31,25,19,13,7,1,2,3,4,5,6,12,18,24,30,36,35,29,23,17,11,10,9,8,14,20,26,32,33,27,21,15,16,22,28,34
    }

    public void traverse(int[][] arr) {
        var visited = new boolean[arr.length][arr[0].length];
        var forward = true;
        var fPath = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        var bPath = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        var row = arr.length - 1;
        var col = 0;
        var direction = 0;
        var path = fPath;
        var step = path[direction];

        for (var i = 0; i < arr.length * arr[0].length; i++) {
            System.out.print(arr[row][col] + ",");
            visited[row][col] = true;

            var nextRow = row + step[0];
            var nextCol = col + step[1];
            var rowInBound = 0 <= nextRow && nextRow < arr.length;
            var colInbound = 0 <= nextCol && nextCol < arr[0].length;

            if (!rowInBound || !colInbound || visited[nextRow][nextCol]) {
                direction = (direction + 1) % 4;
                step = path[direction];
            } else if (direction == 3) {
                forward = !forward;
                direction = 0;
                path = forward ? fPath:bPath;
                step = path[direction];
            }
            row += step[0];
            col += step[1];

        }
    }
}
