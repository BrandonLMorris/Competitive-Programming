import java.util.*;
import java.io.*;

public class Order_Comp {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    for (int t = 1;; t++) {
      int n = Integer.parseInt(in.readLine());
      if (n == 0) break;
      LinkedList<String> frontHalf = new LinkedList<String>();
      LinkedList<String> backHalf = new LinkedList<String>();
      for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
          frontHalf.addLast(in.readLine());
        } else {
          backHalf.addFirst(in.readLine());
        }
      }
      System.out.println("SET " + t);
      while (!frontHalf.isEmpty()) {
        System.out.println(frontHalf.removeFirst());
      }
      while (!backHalf.isEmpty()) {
        System.out.println(backHalf.removeFirst());
      }
    }

  }
}