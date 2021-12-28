package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    	var map = new HashMap<Integer, Integer>();
    	ar.forEach(i -> {
    		if(map.containsKey(i)) {
    			map.put(i, map.get(i) + 1);
    		} else {
    			map.put(i, 1);
    		}
    	});
    	
    	var pairs = map.values().stream().reduce(0, (a,b) -> a + (b / 2));
    	return pairs;
    }

}

public class SockMerchant {
    public static void main(String[] args) throws IOException {
       

        List<Integer> ar = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);

        int result = Result.sockMerchant(ar.size(), ar);
        System.out.println(result);

    }
}