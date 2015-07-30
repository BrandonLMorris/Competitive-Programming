import java.util.*;

public class RedJohnIsBack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Create bool array to store prime values
        final int MAX_COMBOS = 671;
        boolean[] primes = new boolean[MAX_COMBOS+1];
        primes[0] = true;
        primes[1] = true;
        for(int i = 2; i < MAX_COMBOS+1; i++) {
            if(!primes[i]) {
                for(int j = 2; i*j <= MAX_COMBOS; j++) {
                    primes[i*j] = true;
                }
            }
        }

        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int n = input.nextInt();
            int maxTalls = n/4;
            int counter = 1;
            for(int i = 1; i <= maxTalls; i++) {
                int onsies = n - (i * 4);
                counter += (onsies * i) + 1;
            }

            int primeCounter = 0;
            for(int i = 0; i <= counter; i++) {
                if(!primes[i]) primeCounter++;
            }
            System.out.println(primeCounter);
        }
    }
}
