/**
 * Created by bmorris on 10/11/14.
 */
import java.util.*;

public class MissingPages {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numPages = input.nextInt();
        while (numPages != 0){
            int pageRemoved = input.nextInt();
            int numSheets = numPages / 4;
            int[][] newspaper = new int[numSheets][4];
            int pageCounter = 1;
            for(int i = 0; i < numSheets; i++){
                newspaper[i][0] = pageCounter;
                pageCounter++;
                newspaper[i][1] = pageCounter;
                pageCounter++;
            }
            for(int i = numSheets -1; i >= 0; i--){
                newspaper[i][2] = pageCounter;
                pageCounter++;
                newspaper[i][3] = pageCounter;
                pageCounter++;
            }

            int sheetRemoved = 0;
            for(int i = 0; i < numSheets; i++){
                for(int j = 0; j < 4; j++){
                    if(newspaper[i][j] == pageRemoved){
                        sheetRemoved = i;
                        break;
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                if(newspaper[sheetRemoved][i] == pageRemoved) continue;
                else System.out.print(newspaper[sheetRemoved][i] + " ");
            }
            System.out.println();

            numPages = input.nextInt();
        }
    }
}
