import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeQueue {
    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        var s = new Stack<Character>();
        var q = new ArrayDeque<Character>();

        for (char c : string.toLowerCase().toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                s.push(c); 
                q.add(c);  
            }
        }

        boolean palindrome = true;

       while(palindrome && !s.isEmpty() && !q.isEmpty()) {
           var sc = s.pop();
           var qc = q.remove();
           palindrome = palindrome && sc.equals(qc);
        }
        
        return palindrome && s.isEmpty() && q.isEmpty();
    }
    
}
