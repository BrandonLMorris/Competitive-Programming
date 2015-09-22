import java.util.*;

public class Vauvau {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    boolean[] agressive1 = new boolean[999];
    int i = 0;
    boolean isAgressive = true;
    int counter = a;
    while (i < 999) {
      agressive1[i] = isAgressive;
      counter--;
      if (counter == 0) {
        counter = isAgressive ? b : a;
        isAgressive = !isAgressive;
      }
      i++;
    }

    a = in.nextInt();
    b = in.nextInt();
    isAgressive = true;
    boolean[] agressive2 = new boolean[999];
    i = 0;
    counter = a;
    while (i < 999) {
      agressive2[i] = isAgressive;
      counter--;
      if (counter == 0) {
        counter = isAgressive ? b : a;
        isAgressive = !isAgressive;
      }
      i++;
    }

    for (int j = 0; j < 3; j++) {
      int postman = in.nextInt() - 1;
      if (agressive1[postman] && agressive2[postman])
        System.out.println("both");
      else if (agressive1[postman] || agressive2[postman])
        System.out.println("one");
      else
        System.out.println("none");
    }

  }
}
