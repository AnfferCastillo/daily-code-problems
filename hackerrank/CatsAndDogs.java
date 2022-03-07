import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatsAndDogs {
	
	public static void main(String[] args) {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      try {
	          var queryNumber = Integer.parseInt(br.readLine());
	          Integer[][] data = new Integer[queryNumber][3];
	          
	          
	          for(var i = 0; i < queryNumber; i++) {
	        	  Integer[] positions = new Integer[3];
	        	  var positionStrings = br.readLine().split(" ");
	        	  for(var j = 0; j < positionStrings.length; j++) {
	        		  positions[j] = Integer.parseInt(positionStrings[j]);
		          }
	        	  data[i] = positions;
	          }
         
	         
	          for(var positions: data) {
	        	  var catAtoMouse = Math.abs(positions[0] - positions[2]);
	        	  var catBtoMouse = Math.abs(positions[1] - positions[2]);
	        	  
	        	  if(catAtoMouse == catBtoMouse) {
	        		  System.out.println("Mouse C");
	        	  } else if(catAtoMouse > catBtoMouse) {
	        		  System.out.println("Cat B");
	        	  } else {
	        		  System.out.println("Cat A");
	        	  }
	        	  
	          }
	          
	       } catch (IOException ioe) {
	          System.out.println(ioe);
	       }
	}

}
