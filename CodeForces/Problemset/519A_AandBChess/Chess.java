import java.util.*;

public class Chess {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int white = 0;
    int black = 0;
    for (int i = 0; i < 8; i++) {
      char[] line = input.nextLine().toCharArray();
      for (char c : line) {
        switch (c) {
          // White pieces
          case 'Q': white += 9; break;
          case 'R': white += 5; break;
          case 'B': white += 3; break;
          case 'N': white += 3; break;
          case 'P': white += 1; break;
          // Black pieces
          case 'q': black += 9; break;
          case 'r': black += 5; break;
          case 'b': black += 3; break;
          case 'n': black += 3; break;
          case 'p': black += 1; break;
          // For anything else
          default: break;
        }
      }
    }
    if (white == black) System.out.println("Draw");
    else System.out.println(white > black ? "White" : "Black");
  }
}
