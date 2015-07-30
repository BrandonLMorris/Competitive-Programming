//Prime number generator
//generates prime numbers up to a specific value, stores in array list
//designed to test timing for Sherlock and GCD problem (HackerRank)
import java.util.*;

public class PrimeNumberGenerator {
	public static void main(String[] args){
		final int NUM_PRIMES = 100000;
		ArrayList<Integer> primes = new ArrayList<Integer>(NUM_PRIMES);
		primes.add(1);
		primes.add(2);
		for(int i = 3; i < NUM_PRIMES; i++){
			boolean isPrime = true;
			for(int j = 2; j < i; j++){
				if(primes.contains(j)){
					if(i % j == 0){
						isPrime = false;
						break;
					}
				}
			}
			if(isPrime) primes.add(i);
		}
	}
}