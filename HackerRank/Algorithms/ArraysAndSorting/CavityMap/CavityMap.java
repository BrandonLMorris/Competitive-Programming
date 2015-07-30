/**
 * Cavity Map
 * HackerRank :: Algorithms :: Arrays and Sorting
 * Created by Brandon Morris 11/4/2014
 */
import java.util.*;

public class CavityMap{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine()); 

        //Store the map in array map
        char[][] map = new char[n][n];

        //build the map
        for(int i = 0; i < n; i++) {
            String str = input.nextLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < n-1; j++) {
                if(isCavity(map, i, j)) {
                    map[i][j] = 'X';
                }
            }
        }

        //print the resulting map
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isCavity(char[][] map, int i, int j) {
        //check if any adjacent values are cavities
        if(map[i+1][j] != 'X' && map[i-1][j] != 'X' &&
           map[i][j+1] != 'X' && map[i][j-1] != 'X') {
            //if no other cavities, check values
            int depth = map[i][j] - 48;
            if(depth > map[i+1][j]-48 && depth > map[i-1][j]-48 &&
               depth > map[i][j+1]-48 && depth > map[i][j-1]-48) {
                //if all true, then must be cavity
                return true;
               }
        }
        return false;
    }
}

/**
 * An n by n map is given, each cell denoting its depth
 * A cell is a cavity iff cell is 
 * 1) Not on the border, and
 * 2) Each adjecent cell is smaller in depth
 *
 * Output the map with each cavity replaced by an 'X'
 */
