package leetcode;

import java.util.HashMap;

/**You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

 Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.



 Example 1:

 Input: equations = ["a==b","b!=a"]
 Output: false
 Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 There is no way to assign the variables to satisfy both equations.
 Example 2:

 Input: equations = ["b==a","a==b"]
 Output: true
 Explanation: We could assign a = 1 and b = 1 to satisfy both equations.


 Constraints:

 1 <= equations.length <= 500
 equations[i].length == 4
 equations[i][0] is a lowercase letter.
 equations[i][1] is either '=' or '!'.
 equations[i][2] is '='.
 equations[i][3] is a lowercase letter.

 *
 */

public class SatisfiabilityofEqualityEquations990 {

    private final String EQUALITY = "==";
    private final String INEQUALITY = "!=";

    public boolean equationsPossible(String[] equations) {
        var mapOfVariables = new HashMap<Character, Character>();
        for(var equation:equations) {
            var x = equation.charAt(0);
            var y = equation.charAt(3);
            var operation = equation.substring(1,3);
            var prevX = mapOfVariables.get(x);
            var prevY = mapOfVariables.get(y);

            if(prevY == null && prevX == null && operation.equals(EQUALITY)){

                    mapOfVariables.put(x,y);
                    mapOfVariables.put(y,x);

            } else if(prevY != null) {

            }
        }
        return true;
    }
}
