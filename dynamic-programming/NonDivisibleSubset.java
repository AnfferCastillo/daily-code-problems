import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, print the size of a maximal subset of S
 * where the sum of any 2 numbers in S' is not evenly divisible by K.
 *
 */
public class NonDivisibleSubset {

	// 1 7
	// index = 2
	// ref = 1 
	//valid = true
	public static void getSet(List<Integer> s, List<Integer> originalSet, int divisor, int index, int ref) {

			if (index >= originalSet.size()) {
				return;
			}
	
			var isValid = true;
			var j = 0;
			while (j < s.size() && isValid) {
				if(originalSet.get(index) != ref) {
					isValid = (s.get(j) + originalSet.get(index)) % divisor != 0;
				} else {
					isValid = false;
				}
				
				j++;
			}
	
			if (isValid) {
				s.add(originalSet.get(index));
			}
	
			getSet(s, originalSet, divisor, index + 1, ref);

	}
	


	// 1,7,2,4
	// 3
	public static int nonDivisibleSubset(int j, List<Integer> s) {

		var max = 0;
		var i = 0;

		while (i < s.size()) {
			var subSet = new ArrayList<Integer>();
			subSet.add(s.get(i));
			getSet(subSet, s, j, 0, s.get(i));
			i++;
			if (subSet.size() > max) {
				max = subSet.size();
			}
		}
		return max;
	}

	public static void main(String[] args) {
		 System.out.println(nonDivisibleSubset(4, List.of(19, 10, 12, 24, 25, 22)));
		 System.out.println(nonDivisibleSubset(3, List.of(1, 7, 2, 4)));
		System.out.println(nonDivisibleSubset(5, List.of(770528134, 663501748, 384261537, 800309024, 103668401,
				538539662, 385488901, 101262949, 557792122, 46058493)));
	}
}
