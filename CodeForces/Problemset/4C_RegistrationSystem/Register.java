import java.util.*;

public class Register {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = Integer.parseInt(input.nextLine());

    HashMap<String, Integer> hm = new HashMap<String, Integer>();

    for (int i = 0; i < n; i++) {
      String str = input.nextLine();
      if (hm.containsKey(str)) {
        System.out.println(str + hm.get(str));
        hm.put(str, hm.get(str)+1);
      } else {
        hm.put(str, 1);
        System.out.println("OK");
      }
    }


  }
}
