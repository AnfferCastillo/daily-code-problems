package leetcode;

public class TransponseMatrix867 {

  public static void main(String[] args) {

    var test = new TransponseMatrix867();
    TransponseMatrix867.print(test.transpose(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); //[[1,4,7],[2,5,8],[3,6,9]]
  }

  public int[][] transpose(int[][] matrix) {
    int[][] matrixt = new int[matrix[0].length][matrix.length];

    for (var i = 0; i < matrix.length; i++) {
      for (var j = 0; j < matrix[i].length; j++) {
        matrixt[j][i] = matrix[i][j];
      }
    }

    return matrixt;
  }

  public static void print(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.print("[");
      for (int i : row) {
        System.out.print(i + " ");
      }
      System.out.println("]");
    }
  }
}
