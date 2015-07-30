import java.util.*;

public class Laptops {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int numLaptops = input.nextInt();

    Laptop[] laptops = new Laptop[numLaptops];

    boolean happyAlex = false;
    for (int i = 0; i < numLaptops; i++) {
      laptops[i] = new Laptop(input.nextInt(), input.nextInt());
    }

    Arrays.sort(laptops);

    // Looking for one where the price is less, but the quality is more
    for (int i = 1; !happyAlex && i < laptops.length; i++) {
      if (laptops[i-1].quality > laptops[i].quality)
        happyAlex = true;
    }

    System.out.println(happyAlex ? "Happy Alex" : "Poor Alex");
  }
}

class Laptop implements Comparable<Laptop> {
  int cost;
  int quality;

  public Laptop(int c, int q) {
    this.cost = c;
    this.quality = q;
  }

  public int compareTo(Laptop l) {
    if (this.cost < l.cost) return -1;
    if (l.cost < this.cost) return 1;
    else return 0;
  }
}
