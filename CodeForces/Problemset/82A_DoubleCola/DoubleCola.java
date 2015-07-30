import java.util.*;

public class DoubleCola {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    String[] names = new String[5];
    names[0] = "Sheldon";
    names[1] = "Leonard";
    names[2] = "Penny";
    names[3] = "Rajesh";
    names[4] = "Howard";

    int p = 0; 
    while (5 * Math.pow(2,p) < n) {
      n -= 5*Math.pow(2,p);
      p++;
    }
    int name = (int) Math.ceil(n / Math.pow(2,p));
    System.out.println(names[name-1]);
 }
}
