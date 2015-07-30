import java.util.*;

public class Num {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();

    if (num == 0) {
      System.out.println("zero");
      return;
    }

    StringBuilder sb = new StringBuilder();
    // Work the tens digit
    switch (num / 10) {
      case 0:
        // 1-9, save for ones digit
        break;
      case 1:
        // Teens. Handle manually
        switch (num) {
          case 10:
            System.out.println("ten");
            break;
          case 11:
            System.out.println("eleven");
            break;
          case 12:
            System.out.println("twelve");
            break;
          case 13:
            System.out.println("thirteen");
            break;
          case 14:
            System.out.println("fourteen");
            break;
          case 15:
            System.out.println("fifteen");
            break;
          case 16:
            System.out.println("sixteen");
            break;
          case 17:
            System.out.println("seventeen");
            break;
          case 18:
            System.out.println("eighteen");
            break;
          case 19:
            System.out.println("nineteen");
            break;
        }
        return;
      case 2:
        if (num == 20) {
          System.out.println("twenty");
          return;
        }
        sb.append("twenty");
        break;
      case 3:
        if (num == 30) {
          System.out.println("thirty");
          return;
        }
        sb.append("thirty");
        break;
      case 4:
        if (num == 40) {
          System.out.println("forty");
          return;
        }
        sb.append("forty");
        break;
      case 5:
        if (num == 50) {
          System.out.println("fifty");
          return;
        }
        sb.append("fifty");
        break;
      case 6:
        if (num == 60) {
          System.out.println("sixty");
          return;
        }
        sb.append("sixty");
        break;
      case 7:
        if (num == 70) {
          System.out.println("seventy");
          return;
        }
        sb.append("seventy");
        break;
      case 8:
        if (num == 80) {
          System.out.println("eighty");
          return;
        }
        sb.append("eighty");
        break;
      case 9:
        if (num == 90) {
          System.out.println("ninety");
          return;
        }
        sb.append("ninety");
        break;
    }

    // Append a hyphen if not less than ten
    if (num > 10) sb.append("-");

    // Handle the one's digit
    switch (num % 10) {
      case 1:
        sb.append("one");
        break;
      case 2:
        sb.append("two");
        break;
      case 3:
        sb.append("three");
        break;
      case 4:
        sb.append("four");
        break;
      case 5:
        sb.append("five");
        break;
      case 6:
        sb.append("six");
        break;
      case 7:
        sb.append("seven");
        break;
      case 8:
        sb.append("eight");
        break;
      case 9:
        sb.append("nine");
        break;
    }

    System.out.println(sb.toString());
  }
}
