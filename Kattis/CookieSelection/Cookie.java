import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * You receive cookies of various sizes. At times, cookies are requested for
 * delivery. Each time you must deliver the median cookie you currently have.
 * If there are c cookies, the median is: if c is odd, (c+1)/2, if c is even,
 * (c/2)+1.
 */

public class Cookie {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    PriorityQueue<Integer> cookieMax = new PriorityQueue<Integer>(10,
        Collections.reverseOrder());
    PriorityQueue<Integer> cookieMin = new PriorityQueue<Integer>();

    while (true) {
      String line = in.readLine();
      if (line == null) break;


      char instruction = line.charAt(0);
      if (instruction == '#') {
        // Print out the median cookie
        System.out.println(cookieMin.poll());
        if (cookieMin.size() != cookieMax.size()) {
          cookieMin.add(cookieMax.poll());
        }
      } else {
        int size = Integer.parseInt(line);
        if (!cookieMin.isEmpty() && size > cookieMin.peek()) {
          cookieMin.add(size);
          if (cookieMin.size() > cookieMax.size()+1) {
            cookieMax.add(cookieMin.poll());
          }
        } else {
          cookieMax.add(size);
          if (cookieMax.size() > cookieMin.size()) {
            cookieMin.add(cookieMax.poll());
          }
        }
      }

    }

  }
}
