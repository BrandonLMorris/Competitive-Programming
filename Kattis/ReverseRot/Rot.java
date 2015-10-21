import java.util.*;
import java.io.*;

public class Rot {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.".toCharArray();

    for (;;) {
      st = new StringTokenizer(in.readLine());
      int rotate = Integer.parseInt(st.nextToken());
      if (rotate == 0) break;
      char[] message = st.nextToken().toCharArray();
      for (int i = 0; i < message.length; i++) {
        int index = -1;
        for (int j = 0; j < alphabet.length; j++) {
          if (message[i] == alphabet[j]) {
            index = j;
            break;
          }
        }
        index = (index + rotate) % alphabet.length;
        message[i] = alphabet[index];
      }
      String temp = new String(message);
      temp = new StringBuffer(temp).reverse().toString();
      System.out.println(temp);
    }
  }
}