import java.util.*;
import java.io.*;

public class Spam_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int whiteCounter = 0;
    int lowerCounter = 0;
    int upperCounter = 0;
    int symbols = 0;

    String line = in.readLine();
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == '_') {
        whiteCounter++;
      } else if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
        upperCounter++;
      } else if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
        lowerCounter++;
      } else {
        symbols++;
      }
    }

    System.out.println((double)whiteCounter/(double)line.length());
    System.out.println((double)lowerCounter/(double)line.length());
    System.out.println((double)upperCounter/(double)line.length());
    System.out.println((double)symbols/(double)line.length());


  }
}