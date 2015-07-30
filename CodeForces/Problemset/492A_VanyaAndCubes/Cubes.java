import java.util.*;

public class Cubes {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numCubes = input.nextInt();
    int counter = 1;
    int i = 1;
    while (counter <= numCubes) {
      i++;
      counter += (i*(i+1))/2;
    }
    System.out.println(i-1);
  }
}
