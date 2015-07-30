//UNSOLVED---Timeout. Algorithm works, but too slowly
/*HackerRank :: Algorithms :: Warmup :: Bigger is Greater
 *Created by Brandon Morris 10/13/14 while bored in LabVIEW workshop
 */
import java.util.*;

public class BiggerIsGreater{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int numTestCases = Integer.parseInt(input.nextLine());
		for(int i = 0; i < numTestCases; i++){
			String line = input.nextLine();
			char[] letters = line.toCharArray();
			boolean hasChanged = false;
			//Arrays.sort(letters);

			ArrayList<Character> charList = new ArrayList<Character>();	//ArrayList to temp store values
			charList.add(letters[letters.length-1]);			//add last element to list

			//Loop works backwords through the array
			//and add elements to the ArrayList until
			//a value greater than the max of the ArrayList
			//is encountered. That element is then swapped
			//with the min of the list, and the rest of the
			//list is sorted.
			for(int j = letters.length-2; j >= 0; j--){
				if(letters[j] < Collections.max(charList)){
					hasChanged = true;
					char temp = letters[j];
					letters[j] = Collections.max(charList);
					charList.remove(Collections.max(charList));
					charList.add(temp);
					Collections.sort(charList);
					for(int index = j+1; index <= letters.length-1; index++){
						int listIndex = 0;
						letters[index] = charList.get(listIndex);
						listIndex++;
					}
					break;
				} else {
					charList.add(letters[j]);
				}
			}

			if(!hasChanged){
				System.out.println("no answer");
			}
			else {
				for(int j : letters){
					System.out.print((char)j);
				}
				System.out.println();
			}
		}
	}
}
