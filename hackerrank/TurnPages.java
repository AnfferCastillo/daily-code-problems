

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        var pagesPairs = new int[(n/2)+1][2];
        var value = 0;
        for(var i = 0; i < pagesPairs.length; i++) {
        	pagesPairs[i][0] = value++;
        	pagesPairs[i][1] = value++;
        }
        
        
        var i = 0;
		if( p <= n /2) {
			for(; i<pagesPairs.length; i++) {
				if(pagesPairs[i][0] == p || pagesPairs[i][1] == p ) {
					break;
				}
			}
		} else {
			for(var j = pagesPairs.length -1 ; j >= 0; j--) {
				if(pagesPairs[j][0] == p || pagesPairs[j][1] == p ) {
					break;
				} else {
					i++;
				}
			}
		}
		 return i;
        
    }

	private static int search(int p, int[][] pagesPairs, boolean reverse) {
		var i = 0;
		if(reverse) {
			for(; i<pagesPairs.length; i++) {
				if(pagesPairs[i][0] == p || pagesPairs[i][1] == p ) {
					break;
				}
			}
		} else {
			for(var j = pagesPairs.length -1 ; j >= 0; j--) {
				if(pagesPairs[j][0] == p || pagesPairs[j][1] == p ) {
					break;
				} else {
					i++;
				}
			}
		}
		 return i;
	}

}

public class TurnPages {
    public static void main(String[] args)  {
     
       

        int result = Result.pageCount(6,3);
        System.out.println(result);

    }
}