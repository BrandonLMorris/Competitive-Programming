import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //k can go to 1,000,000,000
        //a and b can go to 10,000,000

        //long startTime = System.currentTimeMillis();
        int[] primes = new int[10000001];
        //Arrays.fill(primes, true);
        primes[0] = -1;
        primes[1] = -1;
        for(int i = 2; i < primes.length; i++) {
            if(primes[i] == 0) {
                primes[i] = 1;
                int counter = i+i;
                while(counter < primes.length) {
                    primes[counter]++;
                    counter += i;
                }
            }
        }
        //long endTime = System.currentTimeMillis();
        //System.out.println("Took " + (endTime - startTime) + " milliseconds to fill the array");   

        //Map each number to its primacity
        // long startTime = System.currentTimeMillis();
        // HashMap<Integer, Integer> primacityMap = new HashMap<Integer, Integer>();
        // for(int i = 2; i < 10000001; i++) {
        //     if(i % 10000 == 0) System.out.println("Adding " + i + " to the map");
        //     int primacity = 0;
        //     for(int j = 0; j <= i; j++) {
        //         if(primes[j] && i % j == 0)
        //             primacity++;
        //     }
        //     primacityMap.put(i, primacity);
        // }
        // long endTime = System.currentTimeMillis();
        // System.out.println("Took " + (endTime - startTime) + " milliseconds to fill the map");

        int numQuestions = input.nextInt();
        for(int q = 1; q <= numQuestions; q++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int k = input.nextInt();
            int counter = 0;

            if(k > 8) {
                System.out.println("Case #" + q + ": 0");
                continue;
            }
            
            
            for(int num = a; num <= b; num++) {
                //int primacity = 0;
                if(primes[num] == k)
                    counter++;
                
                // if(primacityMap.get(num) == k)
                //     counter++;
            }
        
            System.out.println("Case #" + q + ": " + counter);
        }
    }
}