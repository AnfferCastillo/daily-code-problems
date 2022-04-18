import java.util.HashMap;

public class  MostFrequentCharacterCounter {

	
	public static void main(String[] args) {
		for(String a : args) {
			System.out.println(a);
		}
		String message = "Welcome to this interview, !"
				+ " What is the MOST frequent non-whitespace character in this String?";

				System.out.println(MostFrequentCharacterCounter.getMostFrequentCharacter(message));

	}

	
	public static String getMostFrequentCharacter(String message) {
		var mapCount = new HashMap<Character, Integer>();
		var max = 0;
		String mostFreq = null;
	 for(char c: message.toCharArray()) {
		 if(c != ' ') {
			 if(!mapCount.containsKey(c)) {
				 mapCount.put(c, 1);				 
			 } else {
				 mapCount.put(c, mapCount.get(c) + 1);
			 }

			 if(max < mapCount.get(c)) {
				 max = mapCount.get(c);
				 mostFreq = String.valueOf(c);
			 }
		 }
	 }
	 
		return mostFreq;
	};
	
}
