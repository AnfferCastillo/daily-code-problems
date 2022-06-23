package leetcode;

import java.util.Map;

public class RomanToInteger13 {

  public static void main(String[] args) {
    var test = new RomanToInteger13();
    System.out.println(test.romanToInt("III")); //3
    System.out.println(test.romanToInt("XXVII")); //27*/
    System.out.println(test.romanToInt("CML")); //950
    System.out.println(test.romanToInt("LVIII")); //58
    System.out.println(test.romanToInt("MCMXCIV")); //1994*/
  }

  Map<Character, Integer> values =
      Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

  public int romanToInt(String s) {
    var num = 0;
    var i = s.length() - 1;
    char previous = 'A';
    while (i >= 0) {
      var previousVal = values.getOrDefault(previous, 0);
      if(previousVal <= values.get(s.charAt(i))) {
        num += values.get(s.charAt(i));
      } else {
        num -= values.get(s.charAt(i));
      }
      previous = s.charAt(i);
      i--;
    }

    return num;
  }
}
