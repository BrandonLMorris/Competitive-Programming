import java.util.*;

/*
 * Two guys are shooting at cans from opposite sides, and they eventually hit
 * the same can. Given how many cans each person shot, output how many cans
 * each person did NOT hit.
 */

public class Gangster {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of cans shot
    int harryShot = in.nextInt();
    int larryShot = in.nextInt();

    int totalCans = harryShot + larryShot - 1;

    int harryDidntShoot = totalCans - harryShot;
    int larryDidntShoot = totalCans - larryShot;

    System.out.println(harryDidntShoot + " " + larryDidntShoot);
  }
}
