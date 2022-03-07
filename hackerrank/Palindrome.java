import java.util.Stack;

public class Palindrome {

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
        var auxString = "";
        var auxString2 = "";

        for (char c : string.toLowerCase().toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                s.push(c); 
                auxString += c;   
            }
        }

        while(!s.isEmpty()) {
            auxString2 += s.pop();
        }
        

        return auxString.equals(auxString2);
    }
}
