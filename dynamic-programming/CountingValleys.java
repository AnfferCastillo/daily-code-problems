
public class CountingValleys {

	public static int countingValleys(int steps, String path) {
		var valleyCount = 0;
		var altitude = 0;
		var imInAValley = false;
		
		for (int i = 0; i < path.length(); i++) {
			var step = path.charAt(i);
			
			altitude += step == 'U' ? 1 : -1;
			
			if(altitude < 0 && !imInAValley) {
				imInAValley = true;
			} else if(altitude == 0 && imInAValley ) {
				valleyCount++;
				imInAValley = false;
			}
			
		}
		
		return valleyCount;
	}

	public static void main(String[] args)  {
		System.out.println(CountingValleys.countingValleys(8, "UDDDUDUU"));
	}

}
