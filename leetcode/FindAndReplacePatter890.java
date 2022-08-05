package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
 * You may return the answer in any order.
 *
 * <p>A word matches the pattern if there exists a permutation of letters p so that after replacing
 * every letter x in the pattern with p(x), we get the desired word.
 *
 * <p>Recall that a permutation of letters is a bijection from letters to letters: every letter maps
 * to another letter, and no two letters map to the same letter.
 *
 * <p>Example 1:
 *
 * <p>Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb" Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and
 * b map to the same letter. Example 2:
 *
 * <p>Input: words = ["a","b","c"], pattern = "a" Output: ["a","b","c"]
 *
 * <p>Constraints:
 *
 * <p>1 <= pattern.length <= 20 1 <= words.length <= 50 words[i].length == pattern.length pattern
 * and words[i] are lowercase English letters.
 */
public class FindAndReplacePatter890 {
    public static void main(String[] args){
        var test = new FindAndReplacePatter890();
       // System.out.println(test.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
        System.out.println(test.findAndReplacePattern(new String[]{"ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        var list = new ArrayList<String>();

        for (String word : words) {
            var wordMap = new HashMap<Character, Character>();
            var patternMap = new HashMap<Character, Character>();
            for(var i = 0; i< word.length(); i++) {
                var wc = word.charAt(i);
                var pc = pattern.charAt(i);

                if(!wordMap.containsKey(wc) && !patternMap.containsKey(pc)) {
                    wordMap.put(wc, pc);
                    patternMap.put(pc, wc);
                } else if (wordMap.containsKey(wc) && patternMap.containsKey(wordMap.get(wc))) {

                }

            }

            if(wordMap != null) list.add(word);
        }

        return list;
    }

}
