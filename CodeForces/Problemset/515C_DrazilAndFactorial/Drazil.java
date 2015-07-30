import java.util.*;

public class Drazil {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int numChars = Integer.parseInt(input.nextLine());
    char[] line = input.nextLine().toCharArray();

    ArrayList<Integer> fx = new ArrayList<Integer>();

    for (char c : line) {
      switch (c) {
        case '0':
        case '1': 
          break;
        case '2': 
          fx.add(2);
          break;
        case '3': 
          fx.add(3); 
          break;
        case '4': 
          fx.add(2); 
          fx.add(2); 
          fx.add(3);
          break;
        case '5': 
          fx.add(5); 
          break;
        case '6': 
          fx.add(5);
          fx.add(3);
          break;
        case '7': 
          fx.add(7); 
          break;
        case '8': 
          fx.add(7);
          fx.add(2); 
          fx.add(2); 
          fx.add(2); 
          break;
        case '9': 
          fx.add(7);
          fx.add(3); 
          fx.add(3); 
          fx.add(2); 
          break;
      }
    }

    Collections.sort(fx, Collections.reverseOrder());

    StringBuilder sb = new StringBuilder();
    for (int c : fx) sb.append(c);

    System.out.println(sb.toString());
  }
}
