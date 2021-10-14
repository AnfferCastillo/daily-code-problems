import java.util.Stack;

/**
 * Create a postfix calculator
 * "2 3 1 * + 9 -" = -4
 * 
 */
public class Postfix {
    public static void main(String[] args) {
      System.out.println( "result " + Postfix.postFix("2 3 1 * + 9 -"));

    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String postFix(String expression) {
        var stack = new Stack<Integer>();
        String [] chars = expression.split(" ");
        var result = "";
    	for(var c: chars) {
    		if(Postfix.isNumeric(c)) {
    			stack.add(Integer.valueOf(c));
    		} else if(!stack.isEmpty() && stack.size() > 1) {
    			var b = stack.pop();
    			var a = stack.pop();
    			int value = Postfix.evaluate(a, b, c);
    			stack.add(value);
    			result = ""+value;
    		}
    	}
        
        return result;
    }

	private static int evaluate(Integer a, Integer b, String c) {
		if("+".equals(c)) {
			return Math.addExact(a, b);
		} else if("-".equals(c)) {
			return Math.subtractExact(a, b);
		} else if("*".equals(c)) {
			return Math.multiplyExact(a, b);
		} else if("/".equals(c)) {
			return Math.floorDiv(a, b);
		} else {
			return 0;
		}
	}

}
