package leetcode;
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */
public class ReverseWordsinString557 {

    public static void main(String[] args) {
        var test = new ReverseWordsinString557();
        System.out.println(test.reverseWord("God Ding")); //doG gniD
        System.out.println(test.reverseWord("Let's take LeetCode contest"));//"s'teL ekat edoCteeL tsetnoc"
    }

    public String reverseWord(String s) {
        var result = "";
        var word = "";

        for (var i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                word += s.charAt(i);
            } else {
                result = s.charAt(i) + word + result;
                word = "";
            }
        }

        if(word != "") result = word + result;

        return result;
    }
}
