import java.util.*;
import java.math.BigInteger;

public class Divorce {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    BigInteger bi =  new BigInteger(in.nextLine());

    System.out.println(bi.divideAndRemainder(new BigInteger("7"))[1].intValue());
  }
}
