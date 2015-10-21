import java.util.*;
import java.io.*;

public class Guess {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String response = "";
    int guess = 500;
    int upper = 1000;
    int lower = 1;
    System.out.println(guess);
    response = in.readLine();
    while (!(response.charAt(0) == 'c')) {
      if (response.charAt(0) == 'l') {
        upper = guess - 1;
        guess = (lower + upper) / 2;
      } else {
        lower = guess + 1;
        guess = (lower + upper) / 2;
      }
      System.out.println(guess);
      response = in.readLine();
    }
    System.exit(0);
  }
}