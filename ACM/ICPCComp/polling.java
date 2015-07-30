import java.util.*;

public class polling {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String s;
		HashMap<String, Integer> names = new HashMap(n);
		ArrayList<String> list = new ArrayList();
		for(int i = 0; i < n; i++) {
			s = input.next();
			if(names.containsKey(s)) {
				Integer val = names.get(s);
				val += 1;
				names.put(s, val);
			} else {
				list.add(s);
				names.put(s, 1);
			}
		}
		int max = 0;
		ArrayList<String> winners = new ArrayList();
			
			for(String str : list) {
				if (names.get(str) >= max) {
					max = names.get(str);
				}
			}
			
			for(String str : list) {
				if (names.get(str) == max) {
					winners.add(str);
				}
			}
			Collections.sort(winners);
			for(String str : winners) {
				System.out.println(str);
			}
	}
}

	
	


