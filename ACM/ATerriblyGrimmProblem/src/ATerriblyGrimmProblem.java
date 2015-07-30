/**
 *
 * ICPC 2012 F
 * Created by bmorris on 9/18/14.
 */
import java.util.*;

public class ATerriblyGrimmProblem {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int lowBound = input.nextInt();
        int highBound = input.nextInt();

        while(lowBound != 0){
            for(int i = lowBound; i <= highBound; i++){
                for(int j = 2; j < i; j++){
                    if(i % j == 0){
                        if(isPrime(j)){
                            if(i == highBound) System.out.print(j);
                            else System.out.print(j + " ");
                            break;
                        }
                    }
                }
            }

            System.out.println();
            lowBound = input.nextInt();
            highBound = input.nextInt();
        }

    }

    private static boolean isPrime(int x){
        boolean prime = true;
        if(x == 2) return prime;
        for(int i = 2; i < x; i++){
            if(x % i == 0){
                prime = false;
            }
        }
        return prime;
    }

}
