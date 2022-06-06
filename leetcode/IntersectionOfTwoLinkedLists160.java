package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoLinkedLists160 {

  public static void main(String[] args) {
    var node1 = new ListNode(4);
      var node2 = new ListNode(1);
      var node3 = new ListNode(8);
      var node4 = new ListNode(4);
      var node5 = new ListNode(5);

      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      node4.next = node5;

      var nodeB1 = new ListNode(5);
      var nodeB2 = new ListNode(6);
      var nodeB3 = new ListNode(1);

      nodeB1.next = nodeB2;
      nodeB2.next = nodeB3;
      nodeB3.next = node3;

    //System.out.println(IntersectionOfTwoLinkedLists160.getIntersectionNode(node1, nodeB1));

    var nodeTest1 = new ListNode(1);
    var nodeTestB1 = new ListNode(1);

    nodeTest1.next = nodeTestB1;
      System.out.println(IntersectionOfTwoLinkedLists160.getIntersectionNode(nodeTest1, nodeTestB1));


  }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        var set = new HashSet<ListNode>();
        var currentA = headA;
        while(currentA != null) {
            set.add(currentA);
            currentA = currentA.next;
        }

        currentA = headB;
        while(set.add(currentA) && currentA != null) {
            currentA = currentA.next;
        }

        return currentA;
    }
}




   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

       @Override
       public String toString() {
           return String.valueOf(val) ;
       }
   }

