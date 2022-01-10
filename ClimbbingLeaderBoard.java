import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ClimbbingLeaderBoard {
	
	//100,90,80,75,60
	//50,65,77,90,102
	public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
		
		var rankedForPalyer = new ArrayList<Integer>();
		
		var j = 1; 
		var previousValue = -1;
		var table = new ArrayList<Integer>();
		
		for(var rank : ranked) {
			if(rank != previousValue) {
				previousValue = rank;
				table.add(rank);
			}
		}
		
		//Look for an insertion point for each one of the scores in player
		//add that index into the rankedForPlayer array
		
		for(int score:player) {
			int i = table.size();
			while(i > 0 && table.get(i-1) <= score) i--;
			
			rankedForPalyer.add(i+1);
			if(i == table.size()) {
				table.add(score);
			} else if(i < 0 )  { 
				table.add(0, score);
			} else if(score != table.get(i)) {
				table.add(i, score);
			}
			
		}
		
		
		return  rankedForPalyer;
	}
	
	public static void main(String[] args) {
		//var ranked = new ArrayList<Integer>();
		//var player = new ArrayList<Integer>();
		var ranked = List.of(100,100,50,40,40,20,10);
		var player = List.of(5,25,50,120);
		
//		ranked.addAll(List.of(100,90,90,80,75,60));
//		player.addAll(List.of(50,65,77,90,102));
		
		System.out.println(ClimbbingLeaderBoard.climbingLeaderboard(ranked, player));
	}

}
