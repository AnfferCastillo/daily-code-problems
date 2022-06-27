package leetcode;

import java.util.LinkedList;
import java.util.List;

public class MergeTwoSortedLists21 {

  public static void main(String[] args) {
    var node = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(4);

    node.next = node2;
    node2.next = node3;

    var node11 = new ListNode(1);
    var node12 = new ListNode(3);
    var node13 = new ListNode(4);

    node11.next = node12;
    node12.next = node13;

    /*[-9,-7,-7,-7,-6,-6,-5,-3,-3,-3,-1,2,2,3,4]
    -9 -7 -7 -6 -6 -5 -3 -3 -3 -1 2 2 3 4*/
    var test = new MergeTwoSortedLists21();
    var result  = test.mergeTwoLists(node, node11);
   // var list1 = test.buildList(new int[]{-9,-7,-3,-3,-1,2,3});
    //var list2 = test.buildList(new int[]{-7,-7,-6,-6,-5,-3,2,4});
    //var result  = test.mergeTwoLists(list1, list2);
    while(result!= null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var queue = new LinkedList<ListNode>();
    if(list1 != null && list2 == null) return list1;
    if(list2 != null && list1 == null) return list2;

    while(list1 != null && list2 != null) {
      if(list1.val > list2.val) {
        queue.add(list2);
        list2 = list2.next;
      } else if(list1.val < list2.val) {
        queue.add(list1);
        list1 = list1.next;
      }else {
        queue.add(list1);
        queue.add(list2);
        list1 = list1.next;
        list2 = list2.next;
      }
    }

    var head = queue.poll();
    var tail = head;
    while(!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;
    }

    if(list1 != null) tail.next = list1;
    if(list2 != null) tail.next = list2;
    
    return head;
  }

  private ListNode explore(ListNode list1, ListNode list2, ListNode current) {
    if(list1 != null && list2 == null) return list1;
    if(list2 != null && list1 == null) return list2;
    if(list2 == null && list1 == null) return null;

    if(current == null) {
      current = new ListNode(0);
      if(list1.val <= list2.val) {
        current.val = list1.val;
        explore(list1.next, list2, current);
      } else {
        current.val = list2.val;
        explore(list1, list2.next, current);
      }
    } else {
      if(list1.val <= list2.val) {
        current.next = new ListNode(list1.val);
        explore(list1.next, list2, current.next);
      } else {
        current.next = new ListNode(list2.val);
        explore(list1, list2.next, current.next);
      }
    }

    return current;
  }


  public ListNode buildList(int[] numbers) {
    var root = new ListNode(numbers[0]);
    ListNode previous = null;

    for(int i : numbers) {
      var current = new ListNode(i);
      if(previous == null) {
        previous = current;
        root = current;
      } else {
        previous.next = current;
        previous = current;
      }
    }
    return root;
  }


}
