package leetcode;

public class PalindromeNumber9 {

  public static void main(String[] args) {
    var test = new PalindromeNumber9();

    System.out.println(test.isPalindrome(3333)); // true
      System.out.println(test.isPalindrome(33333)); //true
      System.out.println(test.isPalindrome(121)); //true
      System.out.println(test.isPalindrome(-121)); //false
      System.out.println(test.isPalindrome(10)); //false
  }

    public boolean isPalindrome(int x) {
        var numString = String.valueOf(x);

        var i = 0;
        var j = numString.length() - 1;

        while(i < j && numString.charAt(i) == numString.charAt(j)) {
            i++;
            j--;
        }

        return i >= j;
    }
}
