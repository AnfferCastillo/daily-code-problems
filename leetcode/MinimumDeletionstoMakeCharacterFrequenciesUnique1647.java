package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique1647 {

  public static void main(String[] args) {
    var test = new MinimumDeletionstoMakeCharacterFrequenciesUnique1647();
    // System.out.println(test.minDeletions("aabbcc")); //3//
    System.out.println(test.minDeletions("bbcebab"));//2
  }

    public int minDeletions(String s) {
        var count = 0;
        var map = new HashMap<Character, Integer>();
        var set = new HashSet<Integer>();

        for(var c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        for(var entry : map.entrySet()) {
            var frecuency = entry.getValue();
            while(set.contains(frecuency)) {
                frecuency--;
                count++;
            }
            if(frecuency != 0)
                set.add(frecuency);
        }


        return count;
    }
}
