import java.util.*;

public class AlternatingCharacters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTests = Integer.parseInt(input.nextLine());
		for(int t = 0; t < numTests; t++) {
			int counter = 0;
			String str = input.nextLine();
			char compareChar = str.charAt(0);
			for(int i = 1; i < str.length(); i++) {
				if(compareChar == str.charAt(i)) {
					counter++;
					continue;
				} else {
					compareChar = str.charAt(i);
				}
			}
			System.out.println(counter);
		}
	}
}