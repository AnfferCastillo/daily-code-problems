import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ElectronicShotHackerRank {
	
	public static int getBudget(Integer[] k, Integer[] u, int b) {
		
		var maxPurchase = -1;
		Arrays.sort(k,Collections.reverseOrder());
		Arrays.sort(u);

		
		for(int i = 0, j = 0; i < k.length; i++) {
			for(;j < u.length; j++) {
				if(u[j] + k[i] > b  ) {
					break;
				}
				if(u[j] + k[i] > maxPurchase) {
					maxPurchase = u[j] + k[i];
				}
			}
		}
		
		return maxPurchase;
	}
	
	public static void main(String[] args) {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      try {
	          var firstLine = br.readLine().split(" ");
	          var secondLine = br.readLine().split(" ");
	          var thirdLine = br.readLine().split(" ");
          
	          int b = Integer.parseInt(firstLine[0]);
	          var k = new Integer[secondLine.length];
	          for(var i = 0; i < secondLine.length; i++) {
	        	  k[i] = Integer.parseInt(secondLine[i]);
	          }

	          var u = new Integer[thirdLine.length];
	          for(var i = 0; i < thirdLine.length; i++) {
	        	  u[i] = Integer.parseInt(thirdLine[i]);
	          }

	          System.out.println(getBudget(k, u, b));
	       } catch (IOException ioe) {
	          System.out.println(ioe);
	       }
		
	}

}
