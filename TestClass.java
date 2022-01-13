
public class TestClass {
	
	public static void main(String[] args) {
		String message = "Welcome to this interview, !"
				+ " What is the MOST frequent non-whitespace character in this String?";

		MostFrequentCharacterCounter characterCounter = new MostFrequentCharacterCounter(message);

		System.out.println("result: [" + characterCounter.getMostFrequentCharacter() + "]");
	}

}






