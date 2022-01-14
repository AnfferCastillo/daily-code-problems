import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueensAttackII {

	// Crear una matriz NxN, llena de 0 en posiciones sin obstaculos y 1 donde hayan obstaculos
	// Hacer un depth first para las 8 direcciones que ataca la reina y por cada iteracion sin obstaculos sumar 1
	
	// [(5,5), (4,2), (2,3)]
	/**
	 * [[],
	 * 	[],
	 * 	[],
	 * 	[],
	 * 	[]]
	 * @param obstacles
	 * @param n
	 * @return
	 */
	public static int[][] fillBoard(List<List<Integer>> obstacles, int n) {
		var board = new int[n][n];
		
		// n = (4,4)
		for(var i = n-1; i >= 0; i--) {
			board[i] = new int[n];
			for(var j = 0; j < n; j++) {
				if(thereIsAnObstacle(i,j, obstacles)) {
					board[i][j] = 1;
				}
			}
		}
		
		
		return board;
		
	}
	
	private static boolean thereIsAnObstacle(int i, int j, List<List<Integer>> obstacles) {
		var test = obstacles.stream().filter(rc -> rc.get(0) == i && rc.get(1) == j).findAny();
		return test.isPresent();
	}
	
	
	public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
	    // Write your code here
		//var board = fillBoard(obstacles, n);
		var count = 0;
		
		//queens position 0 indexed
		var queenRow = r_q - 1;
		var queenCol = c_q -1;
		
		count += explore(obstacles, queenRow -1 , queenCol, "UP", n);
		count += explore(obstacles, queenRow + 1, queenCol, "DOWN", n);
		count += explore(obstacles, queenRow, queenCol - 1, "LEFT", n);
		count += explore(obstacles, queenRow, queenCol + 1, "RIGHT", n);
		count += explore(obstacles, queenRow - 1, queenCol + 1, "UP_RIGHT", n);
		count += explore(obstacles, queenRow - 1, queenCol - 1, "UP_LEFT", n);
		count += explore(obstacles, queenRow + 1, queenCol - 1, "DOWN_LEFT", n);
		count += explore(obstacles, queenRow + 1, queenCol + 1, "DOWN_RIGHT", n);
		
		
		return count;
	}
	
	
	
	private static int explore(List<List<Integer>> obstacles, int i, int j, String direction, int length) {
		var validRow = i <= length && i > 0;
		var validCol = j <= length&& j > 0;
		if(!validRow  || !validCol)
			return 0;
		
		if(thereIsAnObstacle(i,j, obstacles)) 
			return 0;
		
		var count = 1;
		
		if(direction == "UP") {
			count += explore(obstacles, i - 1, j,  direction, length);
		} else if(direction == "DOWN") {
			count += explore(obstacles, i + 1, j,  direction, length);
		} else if(direction == "LEFT") {
			count += explore(obstacles, i, j - 1,  direction, length);
		} else if(direction == "RIGHT") {
			count += explore(obstacles, i, j + 1,  direction, length);
		} else if(direction == "UP_RIGHT") {
			count += explore(obstacles, i - 1, j + 1,  direction, length );
		} else if(direction == "UP_LEFT") {
			count += explore(obstacles, i - 1, j - 1,  direction, length);
		} else if(direction == "DOWN_LEFT") {
			count += explore(obstacles, i + 1, j - 1,  direction, length);
		} else if(direction == "DOWN_RIGHT") {
			count += explore(obstacles, i + 1, j + 1,  direction, length);
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		System.out.println( queensAttack(5 , 3, 4,3,List.of(List.of(5,5), List.of(4,2),List.of(2,3))));
		System.out.println( queensAttack(100000 , 0 , 4187,5068,Collections.emptyList()));
	}
}
