import java.util.List;
import java.util.Scanner;

public class OrganizeBallsContainer {

	public static String organizingContainers(List<List<Integer>> container) {
		var result = "Possible";
		int[] a = new int[container.size()];
		int[] b = new int[container.size()];
		for (int i = 0; i < container.size(); i++) {
			for (int j = 0; j < container.size(); j++) {
				a[i] += container.get(i).get(j);
				b[j] += container.get(i).get(j);
			}
		}
		
		for (int i = 0; i < container.size(); i++) {
			int j = 0;
			for (j = i; j < container.size(); j++) {
				if (a[i] == b[j]) {
					int temp = b[j];
					b[j] = b[i];
					b[i] = temp;
					break;
				}
			}
			if (j == container.size()) {
				result = "Impossible";
				break;
			}
		}
		
			
		return result;
	}

	public static void main(String[] args) {
	

	}

}
