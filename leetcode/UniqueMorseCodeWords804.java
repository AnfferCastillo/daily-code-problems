package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of
 * dots and dashes, as follows:
 *
 * <p>'a' maps to ".-", 'b' maps to "-...", 'c' maps to "-.-.", and so on. For convenience, the full
 * table for the 26 letters of the English alphabet is given below:
 *
 * <p>[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Given an array of strings words where each word can be written as a concatenation of the Morse
 * code of each letter.
 *
 * <p>For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-",
 * and "-...". We will call such a concatenation the transformation of a word. Return the number of
 * different transformations among all words we have.
 *
 * <p>Example 1:
 *
 * <p>Input: words = ["gin","zen","gig","msg"] Output: 2 Explanation: The transformation of each
 * word is: "gin" -> "--...-." "zen" -> "--...-." "gig" -> "--...--." "msg" -> "--...--." There are
 * 2 different transformations: "--...-." and "--...--.". Example 2:
 *
 * <p>Input: words = ["a"] Output: 1
 *
 * <p>Constraints:
 *
 * <p>1 <= words.length <= 100 1 <= words[i].length <= 12 words[i] consists of lowercase English
 * letters.
 */
public class UniqueMorseCodeWords804 {

    public static void main(String[] args){
        var test = new UniqueMorseCodeWords804();
        System.out.println(test.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"})); //2
    }

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String[] ALPHABET_MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        var lettersToMorse = new HashMap<Character, String>();
        for(var i = 0; i < ALPHABET.length(); i++) {
            lettersToMorse.put(ALPHABET.charAt(i), ALPHABET_MORSE[i]);
        }
        var set = new HashSet<String>();
        var count = 0;
        for (var word : words) {
            var morse = translate(word, lettersToMorse);
            if(!morse.isEmpty() && set.add(morse)) count++;
        }

        return count;
    }

    public String translate(String word, Map<Character, String> dictionary)  {
        String translation = "";
        for (var c : word.toCharArray()) {
            translation += dictionary.get(c);
        }
        return translation;
    }
}
