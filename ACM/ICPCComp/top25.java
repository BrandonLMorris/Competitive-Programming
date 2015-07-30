import java.util.*;

public class top25 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = input.next();
		}
		String next = "";
		int counter = 0;
		HashMap<String, Integer> hm = new HashMap();
		for(int i = 0; i < n; i++) {
			counter++;
			if (hm.containsKey(arr[i])) {
				hm.remove(arr[i], 1);
				if (hm.isEmpty()) {
					System.out.println(counter);
					counter = 0;
				}
			} else {
				hm.put(arr[i], 1);
			}
			next = input.next();
			if (hm.containsKey(next)) {
				hm.remove(next);
				if (hm.isEmpty()) {
					System.out.println(counter);
					counter = 0;
				}
			} else {
				hm.put(next, 1);
			}	
			
				
			//if hm1 contains s.next(), remove s.next
			//if hm1 is empty, output counter, reset counter
		}
	}
}

	
	


