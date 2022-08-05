package leetcode;

import java.util.Stack;

public class ValidParentheses20 {

  public static void main(String[] args) {
    var test = new ValidParentheses20();
    System.out.println(test.isValid("()")); // true
      System.out.println(test.isValid("()[]{}")); // true
      System.out.println(test.isValid("(]")); // false
	System.out.print("Testing");					      
  }

    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var c : s.toCharArray()) {
            if( c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                var top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
