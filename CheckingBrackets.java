import java.util.Stack;

public class CheckingBrackets {

    public static void main(String[] args) {
     System.out.println(  checking("{2[3(5+4)]}")); // true
        System.out.println(checking("[{{})}]")); // false
        System.out.println(checking("[()]{}{[()()]()}")); // true
        System.out.println(checking("[(])")); // false
    }

    /*
    stack   
    */

    public static boolean checking(String s) {
        Stack<Character> stack =  new Stack<>();
        var isOk = false;
        for(var i = 0; i < s.length(); i++) {
             var c = s.charAt(i);
             if(c == '{' || c == '[' || c == '(') {
                stack.add(c);
             } else if(c == ')' || c == '}' || c == ']') {
                isOk = checkStack(stack, c);
             }
        }

        return isOk;
    }

    public static boolean checkStack(Stack<Character> stack, char c) {
        if(stack.isEmpty()) {
            return false;
        } else {
            var stackedChar = stack.pop();
            if(c == '}' ) {
                return stackedChar == '{';
            } else if(c == ']') {
                return stackedChar == '[';
            } else if( c == ')') {
                return stackedChar == '(';
            }

        }
        return false;
    }
    
}
