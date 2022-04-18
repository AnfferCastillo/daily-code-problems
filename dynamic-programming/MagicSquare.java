import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.monitor.GaugeMonitor;

public class MagicSquare {

	public static List<List<Integer>> getMagicSquares() {
		List<List<Integer>> magicSquares = new ArrayList<>();
		magicSquares.add(List.of(4,9,2));
		magicSquares.add(List.of(3,5,7));
		magicSquares.add(List.of(8,1,6));
		
		magicSquares.add(List.of(8,1,6));
		magicSquares.add(List.of(3,5,7));
		magicSquares.add(List.of(4,9,2));
		
		magicSquares.add(List.of(6,1,8));
		magicSquares.add(List.of(7,5,3));
		magicSquares.add(List.of(2,9,4));
		
		magicSquares.add(List.of(4,3,8));
		magicSquares.add(List.of(9,5,1));
		magicSquares.add(List.of(2,7,6));
		
		magicSquares.add(List.of(2,7,6));
		magicSquares.add(List.of(9,5,1));
		magicSquares.add(List.of(4,3,8));
		
		magicSquares.add(List.of(6,7,2));
		magicSquares.add(List.of(1,5,9));
		magicSquares.add(List.of(8,3,4));
		
		magicSquares.add(List.of(2,9,4));
		magicSquares.add(List.of(7,5,3));
		magicSquares.add(List.of(6,1,8));
		
		magicSquares.add(List.of(8,3,4));
		magicSquares.add(List.of(1,5,9));
		magicSquares.add(List.of(6,7,2));

		return magicSquares;
	}
	
	public static int formingMagicSquare(List<List<Integer>> s) {
		var magicSquares = getMagicSquares();

		var minCost = Integer.MAX_VALUE;
		var i = 0;
		
		while( i < magicSquares.size()) {
			var currentCost = 0;
			
			for(var j = 0; j < s.size(); j++) {
				for(var k =  0; k < s.get(j).size(); k++) {
					currentCost += Math.abs(magicSquares.get(i+j).get(k) - s.get(j).get(k));		
				}
			}

			minCost = currentCost < minCost ? currentCost : minCost;

			i += 3;
		}
		return minCost;
	}


	public static void main(String[] args) {
		List<List<Integer>> test = new ArrayList<>();
		//test.add(List.of(5,3,4));
		//test.add(List.of(1,5,8));
		//test.add(List.of(6,4,2));

		//test.add(List.of(4, 9, 2));
		//test.add(List.of(3,5, 7));
		//test.add(List.of(8, 1, 5));

		test.add(List.of(4, 8, 2));
		test.add(List.of(4, 5, 7));
		test.add(List.of(6, 1, 6));

		System.out.println(formingMagicSquare(test));

	}

}
