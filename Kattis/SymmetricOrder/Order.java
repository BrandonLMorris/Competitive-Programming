import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Order {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(in.readLine());
    int setNum = 1;
    while (n != 0) {
      LinkedList<String> frontList = new LinkedList<String>();
      LinkedList<String> backList = new LinkedList<String>();

      int i = 0;
      while (i < n) {
        frontList.addLast(in.readLine());
        i++;
        if (i < n) {
          backList.addFirst(in.readLine());
          i++;
        }
      }

      System.out.println("SET " + setNum);
      while (!frontList.isEmpty()) {
        System.out.println(frontList.poll());
      }
      while (!backList.isEmpty()) {
        System.out.println(backList.poll());
      }

      n = Integer.parseInt(in.readLine());
      setNum++;
    }
  }
}