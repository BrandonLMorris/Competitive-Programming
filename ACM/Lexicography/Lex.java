import java.util.*;

public class Lex {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      char[] word = input.next().toCharArray();
      if (word[0] == '#') break;
      long k = Long.parseLong(input.next());

      Arrays.sort(word);
      int n = word.length;
      ArrayList<Character> wordList = new ArrayList<Character>(n);
      for (char c : word) {
        wordList.add(c);
      }

      System.out.println(findKth(wordList, k-1));

    }

  }

  public static String findKth(ArrayList<Character> list, long k) {

    if (list.size() == 1) return Character.toString(list.get(0));

    long p = findP(list);

    // Print intermediate results
    System.out.println();
    for (char c : list) System.out.print(c);
    System.out.println();
    System.out.println("n: " + list.size());
    System.out.println("p: " + p);
    System.out.println("k: " + k);

    if (p == 1) {
      StringBuilder sb = new StringBuilder();
      for (char c : list) sb.append(c);
      return sb.toString();
    }

    double c = (double) p / list.size();

    char nextChar = list.remove((int)Math.floor((k)/c));

    long newP = findP(list);

    long newK = (k % newP);
    //if (newK == 0) {
    //  newK = newP;
    //}

    return nextChar + findKth(list, newK);
  }

  public static long factorial(long n) {
    long counter = 1;
    for (int i = 1; i <= n; i++) {
      counter *= i;
    }
    return counter;
  }

  public static long findP(ArrayList<Character> list) {
    long[] counts = new long[26];
    for (char c : list) {
      counts[c-'A']++;
    }
    long denom = 1;
    for (long l : counts) {
      denom *= factorial(l);
    }
    long p = factorial(list.size())/denom;
    return p;
  }

}
