import java.util.*;

public class Children {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    LinkedList<Child> list = new LinkedList<Child>();
    for (int i = 1; i <= n; i++) {
      list.add(new Child(input.nextInt(), i));
    }

    while (list.size() > 1) {
      Child c = list.remove();
      c.value -= m;
      if (c.value > 0) list.add(c);
    }

    System.out.println(list.remove().position);

  }

  private static class Child {
    int value;
    int position;
    public Child(int valArg, int posArg) {
      this.value = valArg;
      this.position = posArg;
    }
  }
}
