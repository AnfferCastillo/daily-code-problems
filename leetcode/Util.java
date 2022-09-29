package leetcode;

public class Util {

  public static void print(ListNode l) {
    var current = l;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }

  public static void assertEquals(String expected, String actual) {
    if(!expected.equals(actual)) {
      throw new AssertionError(String.format("Expected: %s but Actual: %s ---- FAILED!", expected, actual));
    } else {
      System.out.println(String.format("Expected: %s - Actual: %s ---- PASS!", expected, actual));
    }
  }

  public static void assertEquals(int expected, int actual) {
    if(actual != expected) {
      throw new AssertionError(String.format("Expected: %s but Actual: %s ---- FAILED!", expected, actual));
    } else {
      System.out.println(String.format("Expected: %s - Actual: %s ---- PASS!", expected, actual));
    }
  }

  public static ListNode buildList(int[] numbers) {
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
