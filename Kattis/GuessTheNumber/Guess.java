import java.util.*;
import java.io.*;

public class Guess {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String response = "";
    int guess = 500;
    int prev = 500;
    System.out.println(guess);
    response = in.readLine();
    while (!response.contains("correct")) {
      if (response.contains("lower")) {
        guess = guess - (int)Math.ceil(prev/2.0);
        prev = (int)Math.ceil(prev/2.0);
      } else {
        guess = guess + (int)Math.ceil(prev/2.0);
        prev = (int)Math.ceil(prev/2.0);
        if (guess > 100) guess = 100;
      }
      System.out.println(guess);
      response = in.readLine();
    }
    System.exit(0);
  }
}