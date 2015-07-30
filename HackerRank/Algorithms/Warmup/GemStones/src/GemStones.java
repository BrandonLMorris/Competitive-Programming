/**
 * Gem Stones
 * HackerRank:Algorithms:Warmup
 * Created by bmorris on 9/26/14.
 */
import java.util.*;

public class GemStones {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int counter = 0;

        int n = Integer.parseInt(input.nextLine());
        char[][] rocks = new char[n][26];

        for(int i = 0; i < n; i++){
            String rock = input.nextLine();
            for(int j = 0; j < rock.length(); j++){
                rocks[i][rock.charAt(j)-'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            boolean gemElement = true;
            for(int j = 0; j < n; j++){
                if(rocks[j][i] == 0) gemElement = false;
            }
            if(gemElement) counter++;
        }
        System.out.println(counter);
    }
}
