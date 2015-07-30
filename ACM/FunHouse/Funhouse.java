import java.util.*;

public class Funhouse {
  public static void main(String[] args) {
    final int RIGHT = 0;
    final int LEFT = 1;
    final int UP = 2;
    final int DOWN = 3;

    Scanner input = new Scanner(System.in);
    for(int t = 1; ; t++) {
      // Input parameters
      String firstLine = input.nextLine();
      Scanner lineScanner = new Scanner(firstLine);
      int width = lineScanner.nextInt();
      int height = lineScanner.nextInt();

      //System.out.println(width + " " + height);

      // Break case
      if (width == 0 && height == 0) break;

      // Input the board
      int entryW = -1;
      int entryH = -1;
      char[][] house = new char[width][height];
      for (int i = 0; i < height; i++) {
        String line = input.nextLine();
        for (int j = 0; j < width; j++) {
          house[j][i] = line.charAt(j);
          if (house[j][i] == '*') {
            entryH = i;
            entryW = j;
          }
        }
      }

      // Determine the current direction to move
      int direction = -1;
      if (entryW == 0) {
        direction = RIGHT;
      } else if (entryH == 0) {
        direction = DOWN;
      } else if (entryW == width - 1) {
        direction = LEFT;
      } else {
        direction = UP;
      }

      char current = house[entryW][entryH];
      int w = entryW;
      int h = entryH;
      while (house[w][h] != 'x') {
        // Handle normal motion
        if (house[w][h] == '.' || house[w][h] == '*') {
          switch (direction) {
            case RIGHT: w++;
              break;
            case LEFT: w--;
              break;
            case UP: h--;
              break;
            case DOWN: h++;
              break;
          }
        } 
        // Handle redirection
        else if (house[w][h] == '/') {
          switch (direction) {
            case RIGHT:
              direction = UP;
              h--;
              break;
            case LEFT:
              direction = DOWN;
              h++;
              break;
            case UP:
              direction = RIGHT;
              w++;
              break;
            case DOWN:
              direction = LEFT;
              w--;
              break;
          }
        } 
        else if (house[w][h] == '\\') {
          switch (direction) {
            case RIGHT: direction = DOWN;
              h++;
              break;
            case LEFT: direction = UP;
              h--;
              break;
            case DOWN: direction = RIGHT;
              w++;
              break;
            case UP: direction = LEFT;
              w--;
              break;
          }
        }
      }

      house[w][h] = '&';

      System.out.println("HOUSE " + t);
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          System.out.print(house[j][i]);
        }
        System.out.println();
      }

    }

  }
}

