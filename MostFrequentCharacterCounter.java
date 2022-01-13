import java.util.HashMap;
import java.util.Iterator;

public class  MostFrequentCharacterCounter {

	private String message;
	
	public MostFrequentCharacterCounter(String message) {
		this.message = message;
	}
	
	public String getMostFrequentCharacter() {
		var mapCount = new HashMap<Character, Integer>();
		
	 for(char c: message.toCharArray()) {
		 if(c != ' ') {
			 if(!mapCount.containsKey(c)) {
				 mapCount.put(c, 1);				 
			 } else {
				 mapCount.put(c, mapCount.get(c) + 1);
			 }
		 }
	 }
		
	 
	 var max = 0;
	 var mostFreq = "";
	 for (var entry : mapCount.entrySet()) {
		if(entry.getValue() > max) {
			max = entry.getValue();
			mostFreq = entry.getKey().toString();
		}
	}
	 
		return mostFreq;
	};
	
}
