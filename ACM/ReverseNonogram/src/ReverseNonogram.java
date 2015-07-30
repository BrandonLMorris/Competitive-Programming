/**
 * Brandon Morris
 * Created by bmorris on 9/20/14.
 */
import java.util.*;

public class ReverseNonogram {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        while(n != 0){
            input.nextLine();

            char[][] nonogram = new char[n][n];
            for(int i = 0; i < n; i++){
                String line = input.nextLine();
                for(int j = 0; j < n; j++){
                    nonogram[i][j] = line.charAt(j);
                }
            }

            for(int i = 0; i < n; i++){
                boolean hasX = false;
                for(int j = 0; j < n; j++){
                    if(nonogram[i][j] == 'X') {
                        int counter = 1;
                        hasX = true;
                        int checkspot = j + 1;
                        while(checkspot < n && nonogram[i][checkspot] == 'X'){
                            counter++;
                            checkspot++;
                        }
                        j = checkspot - 1;
                        boolean hasMoreXs = false;
                        for(;checkspot < n; checkspot++){
                            if (nonogram[i][checkspot] == 'X') hasMoreXs = true;
                        }
                        if(hasMoreXs){
                            System.out.print(counter + " ");
                        }
                        else {
                            System.out.println(counter);
                        }
//                        if(j != n-1 && i != n-1){
//                            System.out.print(counter + " ");
//                        }
//                        else{
//                            System.out.println(counter);
//                        }
                    }
                }
                if(!hasX) System.out.println("0");
            }

            for(int j = 0; j < n; j++){
                boolean hasX = false;
                for(int i = 0; i < n; i++){
                    if(nonogram[i][j] == 'X') {
                        int counter = 1;
                        hasX = true;
                        int checkspot = i + 1;
                        while(checkspot < n && nonogram[checkspot][j] == 'X'){
                            counter++;
                            checkspot++;
                        }
                        i = checkspot - 1;
                        boolean hasMoreXs = false;
                        for(;checkspot < n; checkspot++){
                            if (nonogram[checkspot][j] == 'X') hasMoreXs = true;
                        }
                        if(hasMoreXs){
                            System.out.print(counter + " ");
                        }
                        else {
                            System.out.println(counter);
                        }
//                        if(i != n-1 && j != n-1){
//                            System.out.print(counter + " ");
//                        }
//                        else{
//                            System.out.println(counter);
//                        }
                    }
                }
                if(!hasX) System.out.println("0");
            }


            n = input.nextInt();
        }

    }
}
