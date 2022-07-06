package leetcode;

public class FibonacciNumber509 {

  public static void main(String[] args) {
    var test = new FibonacciNumber509();
    System.out.println(test.fib(2)); //1
      System.out.println(test.fib(3)); //2
      System.out.println(test.fib(4)); //3
      System.out.println(test.fib(5)); // 5
      System.out.println(test.fib(10)); //55
  }

    public int fib(int n) {
        var seq =  new int[n+1];
        if (n <= 1) return n;

        seq[0] = 0;
        seq[1] = 1;

    for (int i = 2; i < seq.length; i++) {
     seq[i] = seq[i-1] + seq[i-2];
    }

        return seq[n];
    }

}
