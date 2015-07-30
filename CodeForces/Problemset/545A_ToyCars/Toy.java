import java.util.*;

public class Toy {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCars = input.nextInt();
    int[][] collisions = new int[numCars][numCars];
    boolean[] isGood = new boolean[numCars];
    for (int i = 0; i < numCars; i++) {
      for (int j = 0; j < numCars; j++) {
        collisions[i][j] = input.nextInt();
      }
    }

    for (int i = 0; i < numCars; i++) isGood[i] = true;

    for (int i = 0; i < numCars; i++) {
      for (int j = i + 1; j < numCars; j++) {
        switch (collisions[i][j]) {
          case 0:
            break;
          case 1:
            isGood[i] = false;
            break;
          case 2:
            isGood[j] = false;
            break;
          case 3:
            isGood[i] = false;
            isGood[j] = false;
            break;
        }
      }
    }

    ArrayList<Integer> goods = new ArrayList<Integer>();
    for (int i = 0; i < numCars; i++) {
      if (isGood[i]) goods.add(i);
    }

    System.out.println(goods.size());
    if (goods.size() > 0) {
      for (int i = 0; i < goods.size(); i++) {
        if (i == goods.size()-1)
          System.out.println((goods.get(i)+1));
        else
          System.out.print((goods.get(i)+1) + " ");
      }
    }
  }
}
