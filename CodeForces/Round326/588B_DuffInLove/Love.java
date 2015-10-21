import java.util.*;

public class Love {
  public static void main(String[] args) {
    int MAX = (int)Math.sqrt(Math.pow(10,12)) + 4;
    boolean[] isNotPrime = new boolean[MAX];
    isNotPrime[0] = true;
    isNotPrime[1] = true;
    isNotPrime[2] = false;
    int ii = 2;
    while (ii < MAX) {
      if (!isNotPrime[ii]) {
        int pos = ii+ii;
        while (pos < MAX) {
          isNotPrime[pos] = true;
          pos += ii;
        }
      }
      ii++;
    }

    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int i = 0; i < MAX; i++) {
      if (!isNotPrime[i]) primes.add(i);
    }
    System.out.println(primes.size());

    ArrayList<Long> squares = new ArrayList<Long>();
    for (int i = 0; i < primes.size(); i++) {
      squares.add((long)Math.pow(primes.get(i), 2));
    }

    

    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    for (long i = n; i >= 0; i--) {
      if (n % i != 0) continue;
      int max = (int)Math.floor(Math.sqrt(i));
      boolean isLovely = true;
      ii = 0;
      while (squares.get(ii) < max) {
        if (i % squares.get(ii) == 0) {
          isLovely = false;
        }
      }
      if (isLovely) {
        System.out.println(i);
        return;
      }
    }
  }

}