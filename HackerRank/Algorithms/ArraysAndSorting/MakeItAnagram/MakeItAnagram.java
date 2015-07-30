/* HackerRank :: Algorithms :: Arrays and Sorting :: Make it Anagram
 * Created by Brandon Morris 10/29/2012
 */
import java.util.*;

public class MakeItAnagram {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	String string1 = input.nextLine();
	String string2 = input.nextLine();

	int[] charArray1 = new int[26];
	int[] charArray2 = new int[26];

	for(int i = 0; i < string1.length(); i++) {
	    charArray1[string1.charAt(i) - 'a']++;
	}

	for(int i = 0; i < string2.length(); i++) {
	    charArray2[string2.charAt(i) - 'a']++;
	}

	int counter = 0;

	for(int i = 0; i < 26; i++) {
	   counter += Math.abs(charArray1[i] - charArray2[i]); 
	}

	System.out.println(counter);
    }
}
