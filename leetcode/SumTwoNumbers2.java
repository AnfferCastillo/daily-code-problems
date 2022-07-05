package leetcode;

import java.util.List;

public class SumTwoNumbers2 {

  public static void main(String[] args) {
    var test = new SumTwoNumbers2();
    var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
  //  Util.print(test.addTwoNumbers(l1, l2)); // 7 0 8

      var l3 = Util.buildList(new int[]{9,9,9,9,9,9,9});
      var l4 = Util.buildList(new int[]{9,9,9,9});
      Util.print(test.addTwoNumbers(l3, l4)); // 8 9 9 9 0 0 0 1
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var carry = 0;
        ListNode root = null;
        ListNode l4 = null;
        while(l1 != null || l2 != null) {
            var current = new ListNode(0);

            var sum = carry;
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;

            if(sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            current.val = sum;

            if(root == null) {
                root = current;
                l4 = current;
            } else {
                l4.next = current;
                l4 = l4.next;
            }

            l1 = l1 != null ?  l1.next : null;
            l2 = l2 != null ?  l2.next : null;
        }

        if(carry != 0) {
            l4.next = new ListNode(carry);
        }

        return root;
    }


}
