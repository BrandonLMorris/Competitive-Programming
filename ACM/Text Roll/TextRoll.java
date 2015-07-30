
import java.util.*;



public class TextRoll{
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			int n = Integer.parseInt(scan.nextLine().trim());
			if (n==0) {
				break;
			}

			String line = scan.nextLine();
			int space = (line.contains(" ")) ? line.indexOf(" ") : line.length();
			//System.out.println("space: " + space);
			for (int i = 1; i < n; i++) {

				line = scan.nextLine();

				if (space < line.length()) {
					line = line.substring(space);
					space += (line.contains(" ")) ? line.indexOf(" ") : line.length();
				}
				//System.out.println("space: " + space);
			}
			System.out.println(space + 1);
		}
			
	}
}