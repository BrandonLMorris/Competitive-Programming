import java.util.*;

public class Structure {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {
      int n = in.nextInt();
      LinkedList<Integer> stack = new LinkedList<Integer>();
      LinkedList<Integer> queue = new LinkedList<Integer>();
      PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(n, Collections.reverseOrder());
      boolean s = true, q = true, p = true;

      for (int i = 0; i < n; i++) {
        if (in.nextInt() == 1) {
          int x = in.nextInt();
          stack.push(x);
          queue.addLast(x);
          pqueue.add(x);
        } else {
          int expected = in.nextInt();
          if (stack.isEmpty()) {
            p = false;
            q = false;
            s = false;
            continue;
          }
          if (expected != stack.pop()) {
            s = false;
          }
          if (expected != queue.pollFirst()) {
            q = false;
          }
          if (expected != pqueue.poll()) {
            p = false;
          }
        }
      }


      if (!s && !p && !q) {
        System.out.println("impossible");
      } else if (s && !p && !q) {
        System.out.println("stack");
      } else if (!s && p && !q) {
        System.out.println("priority queue");
      } else if (!s && !p && q) {
        System.out.println("queue");
      } else {
        System.out.println("not sure");
      }

    }

  }
}
