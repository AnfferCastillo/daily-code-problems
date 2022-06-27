package leetcode;

import java.util.LinkedList;

public class StackUsingQueue225 {

  public static void main(String[] args) {
      StackUsingQueue225 myStack = new StackUsingQueue225();
      myStack.push(1);
      myStack.push(2);
      System.out.println(myStack.top()); // return 2
      System.out.println(myStack.pop()); // return 2
      System.out.println(myStack.empty()); // return False
  }

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    Integer top;

    public StackUsingQueue225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        while(!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        while(!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        top = x;
        queue1.add(x);
    }

    public int pop() {
        var result = queue1.poll();
        if(!queue2.isEmpty()) {
            top = queue2.poll();
            queue1.add(top);
        } else {
            top = null;
        }

        return result;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
