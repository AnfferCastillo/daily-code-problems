package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * <p>Example 1:
 *
 * <p>Input: head = [1,2,3,4,5], left = 2, right = 4 Output: [1,4,3,2,5] Example 2:
 *
 * <p>Input: head = [5], left = 1, right = 1 Output: [5]
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the list is n. 1 <= n <= 500 -500 <= Node.val <= 500 1 <= left <= right
 * <= n
 */
public class ReverseLinkedListII92 {

  public static void main(String[] args) {
    var test = new ReverseLinkedListII92();
    var node5 = new ListNode(5);
    var node4 = new ListNode(4, node5);
    var node3 = new ListNode(3, node4);
    var node2 = new ListNode(2, node3);
    var head = new ListNode(1, node2);
    Util.print(test.reverseBetween(head, 2,4));

    var head2 = new ListNode(3, new ListNode(5));
    Util.print(test.reverseBetween(head2, 1, 2));

    var head3 = new ListNode(5);
    Util.print(test.reverseBetween(head3, 1,1));
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {

    ListNode p = null;
    ListNode current = head;
    Stack<ListNode> s = new Stack<>();
    var k = 1;

    while (current != null) {
      if (k < left) {
        p = current;
        current = current.next;
        k++;
      } else {
        while (k <= right && current != null) {
          s.push(current);
          k++;
          current = current.next;
        }
        if(p == null) {
          head = s.pop();
          p = head;
        }

        while(!s.isEmpty()) {
          var top = s.pop();
          p.next = top;
          p = top;
        }

        p.next = current;
        break;
      }
    }

    return head;
  }
}
