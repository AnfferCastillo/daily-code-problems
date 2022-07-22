package leetcode;

import java.util.LinkedList;

public class PartitionList86 {

  public static void main(String[] args) {
    var test = new PartitionList86();

      var node22 = new ListNode(2);
      var node5 = new ListNode(5, node22);
      var node2 = new ListNode(2, node5);
    var node3 = new ListNode(3, node2);
    var node4 = new ListNode(4, node3);
    var head = new ListNode(1,node4);
    Util.print(test.partition(head, 3));

    var head2 = new ListNode(2,new ListNode(1));
    Util.print(test.partition(head2, 2));

      var node221 = new ListNode(2);
      var node51 = new ListNode(5, node221);
      var node21 = new ListNode(2, node51);
      var node31 = new ListNode(3, node21);
      var node41 = new ListNode(4, node31);
      var head3 = new ListNode(1,node41);
      Util.print(test.partition(head3, 1));

      var head4 = new ListNode(5);
      Util.print(test.partition(head4, 1));

  }

    public ListNode partition(ListNode head, int x) {
        var q1 = new LinkedList<ListNode>();
        var current = head;
        ListNode p = null;

        while(current != null) {
            if(current.val >= x) {
                q1.add(current);
            } else if(p != null) {
               p.next = current;
               p = current;
            } else {
                head = current;
                p = current;
            }
            current = current.next;
        }

        if(p == null) return head;

        while(!q1.isEmpty()) {
            var first = q1.poll();
            p.next = first;
            p = p.next;
            p.next = null;
        }

        return head;
    }

}
