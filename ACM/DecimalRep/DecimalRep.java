import java.util.*;
import java.math.BigDecimal;

public class DecimalRep {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // boolean[] primes = new boolean[501];
        // for(boolean b : primes) {
        //     b = true;
        // }
        // primes[0] = false;
        // primes[1] = false;
        // for(int i = 2; i < 500; i++) {
        //     if(primes[i]) {
        //         int counter = i;
        //         while(counter <= 500) {
        //             primes[counter] = false;
        //         }
        //     }
        // }

        HashMap<Integer, Integer> maxChar = new HashMap<Integer, Integer>();
        maxChar.put(0, 1);
        maxChar.put(1, 1);
        maxChar.put(2, 3);

        for(int i = 3; i <= 500; i++) {
            int currentHighest = maxChar.get(i-1);
            int current = calculateMaxRepeating(i);
            maxChar.put(i, Math.max(currentHighest, current));
        }

        for(;;) {
            int n = input.nextInt();
            if(n == 0) break;
            System.out.println(maxChar.get(n));
        }

    }

    //Maximum repeating decimals will occur under prime numbers
    //Method returns number of repeating decimals by puting argument under 1
    //Does account for additional characters to represent number
    public static int calculateRepeating(int num, int denom){
        boolean[] repeatArr = new boolean[4991];
        boolean repeats = true;
        int counter = 0;
        int result = num%denom;
        while(!repeatArr[result]) {
            if(result == 0) {
                repeats = false;
                break;
            }
            repeatArr[result] = true;
            counter++;
            result = (result*10)%denom;
        }
        if(repeats) return counter + 4;
        else return counter + 2;
    }

    public static int calculateMaxRepeating(int denom) {
        int maxCounter = 0;
        for(int i = 1; i <= denom; i++) {
            int current = calculateRepeating(i, denom);
            if(current > maxCounter) {
                maxCounter = current;
            }
        }
        return maxCounter;
    }
}