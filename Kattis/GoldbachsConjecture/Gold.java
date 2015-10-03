import java.util.*;
import java.io.*;

public class Gold {
  public static void main(String[] args) throws Exception {
    // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Scanner in = new Scanner(System.in);

    // Build up array of prime numbers (Seive of Erathdlajwjlwe)
    boolean[] isNotPrime = new boolean[32001];
    for (int i = 2; i < 32001; i++) {
      if (!isNotPrime[i]) {
        int x = i + i;
        while (x < 32001) {
          isNotPrime[x] = true;
          x += i;
        }
      }
    }
    // Turn it into an array of just the prime values
    int primeCount = 0;
    for (boolean b : isNotPrime) if(!b) primeCount++;
    int[] primes = new int[primeCount];
    int current = 0;
    for (int i = 2; i < isNotPrime.length; i++) {
      if (!isNotPrime[i]) primes[current++] = i;
    }

    int numTests = in.nextInt();
    for (int t = 0; t < numTests; t++) {

      int test = in.nextInt();
      int firstI = 0;

      // Store each representation as a pair
      ArrayList<Pair> reps = new ArrayList<Pair>();

      // Iterate through each pair of primes
      while (primes[firstI] <= test/2) {
        int first = primes[firstI];
        int secondI = firstI;
        while (secondI < primes.length && primes[secondI] < test) {
          int second = primes[secondI];
          if (first + second == test) {
            reps.add(new Pair(first, second));
          }
          secondI++;
        }
        firstI++;
      }

      // Print out each representation
      System.out.println(test + " has " + reps.size() + " representation(s)");
      for (Pair p : reps) {
        System.out.println(p);
      }
      System.out.println();

    }
  }

  // Pair - simple class that holds two values and prints out in desired format
  private static class Pair {
    int first;
    int second;
    public Pair(int _first, int _second) {
      this.first = _first;
      this.second = _second;
    }

    public String toString() {
      return first + "+" + second;
    }
  }
}
