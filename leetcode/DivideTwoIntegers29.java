package leetcode;

public class DivideTwoIntegers29 {

  public static void main(String[] args) {
    var test = new DivideTwoIntegers29();
    System.out.println(test.divide(10, 3)); // 3
    System.out.println(test.divide(7, -3)); // -2
    System.out.println(test.divide(-2147483648, -1)); // -2147483648
    System.out.println(test.divide(-2147483648, 1)); // -2147483648
    System.out.println(test.divide(2147483647, 1)); // 2147483648
  }

  public int divide(int dividend, int divisor) {
    var positiveDividend = dividend >= 0;
    var positiveDivisor = divisor >= 0;
    if (dividend == 1 << 31 && (divisor == -1)) return Integer.MAX_VALUE;
    if (dividend == 1 << 31 && divisor == 1) return dividend;
    var result = iterativeDivision(Math.abs(dividend), Math.abs(divisor));
    if (positiveDivisor != positiveDividend) return Math.negateExact(result);
    else return result;
  }

  public int iterativeDivision(int dividend, int divisor) {
    var result = 0;
    while (dividend - divisor >= 0) {
      var count = 1;
      var auxDiv = divisor;
      var flag = dividend - divisor >= 0;
      while (flag) {

        if (dividend - (auxDiv + auxDiv) >= 0) {
          auxDiv += auxDiv;
          count += count;
        } else flag = false;
      }

      dividend -= auxDiv;
      result += count;
    }

    return result;
  }

  public int recursiveDivision(long dividend, long divisor) {
    if (dividend < divisor) return 0;
    var divisions = 1;
    divisions += recursiveDivision(dividend - divisor, divisor);
    return divisions;
  }
}
