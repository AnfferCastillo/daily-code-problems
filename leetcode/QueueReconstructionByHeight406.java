package leetcode;

import java.util.Arrays;

public class QueueReconstructionByHeight406 {

  public static void main(String[] args) {
    var test = new QueueReconstructionByHeight406();

var result =    test.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println();
  }

    public int[][] reconstructQueue(int[][] people) {

    Arrays.sort(people, (a,b)-> {
        if(a[0] == b[0]) {
            return a[1] - b[1];
        }else{
            return a[0] - b[0];
        }
    });

    var result = new int[people.length][2];

    for(var i = 0; i < result.length; i++) {
        result[i][0] = -1;
    }

    for(var person: people){
        var count = person[1];
        for(var i = 0; i < result.length; i++) {
            if(result[i][0] == -1 && count == 0) {
                result[i] = person;
                break;
            } else if(result[i][0] == -1 || result[i][0] >= person[0]) {
                count--;
            }
        }
    }

    return result;
    }
}
