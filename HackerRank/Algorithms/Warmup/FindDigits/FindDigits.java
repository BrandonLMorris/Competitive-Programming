/*HackerRank :: Algorithms :: Warmup :: Find Digits
 *Created by Brandon Morris 10/13/2014
 */
import java.util.*;

public class FindDigits{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numTestCases = Integer.parseInt(input.nextLine());
		for(int i = 0; i < numTestCases; i++){
			String number = input.nextLine();
			long longNumber = Long.parseLong(number);
			int digitCounter = 0;
			for(int j = 0; j < number.length(); j++){
				int digit = Integer.parseInt(number.substring(j, j+1));
				if(digit > 0 && longNumber % digit == 0) digitCounter++;
			}
			System.out.println(digitCounter);
		}
	}
}
