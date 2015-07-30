import java.util.Scanner;

public class Compression {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    for (int numImage = 1; ; numImage++) {
      String line = input.nextLine();
      Scanner lineScanner = new Scanner(line);
      int width = lineScanner.nextInt();
      if (width == 0) break;
      int threshold = lineScanner.nextInt();

      //Create the bitmap from input
      char[][] bitMap = new char[width][width];
      for (int i = 0; i < width; i++) {
        String bitLine = input.nextLine();
        for (int j = 0; j < width; j++) {
          bitMap[i][j] = bitLine.charAt(j);
        }
      }

      //Compress the bitmap
      //compress(bitMap, 0, width-1, 0, width-1, threshold);
      inspect(bitMap, 0, width-1, 0, width-1, threshold);

      //Print the result
      System.out.println("Image " + numImage + ":");
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < width; j++) {
          System.out.print(bitMap[i][j]);
        }
        System.out.println();
      }
    }
  }

  private static void compress(char[][] map, int left, int right, int top, int bottom, int threshold) {
    /*
     * Compress works in quadrants, based off normal coordinate system
     * 2 | 1
     * 3 | 4
     */

    // Quadrant 1
    inspect(map, (left+right+1)/2, right, top, (top+bottom)/2, threshold);

    // Quadrant 2
    inspect(map, left, (left+right)/2, top, (top+bottom)/2, threshold);

    // Quadrant 3
    inspect(map, left, (left+right)/2, (top+bottom+1)/2, bottom, threshold);

    // Quadrant 4
    inspect(map, (left+right+1)/2, right, (top+bottom+1)/2, bottom, threshold);
  }

  private static void inspect(char[][] map, int left, int right, int top, int bottom, int threshold) {
    int oneCounter = 0;
    int zeroCounter = 0;
    double quadrantSize = (right-left+1)*(right-left+1);

    //System.out.println("Testing quadrant");
    for (int i = top; i <= bottom; i++) {
      for (int j = left; j <= right; j++) {
        //System.out.print(map[i][j]);
        if (map[i][j] == '1') {
          oneCounter++;
        } else {
          zeroCounter++;
        }
      }
      //System.out.println();
    }
    //System.out.println();
    
    double oneRatio = (oneCounter/quadrantSize);
    double zeroRatio = (zeroCounter/quadrantSize);

    if (oneRatio >= (threshold/100.0)) {
      paint(map, left, right, top, bottom, 1);
    } else if (zeroRatio >= (threshold/100.0)) {
      paint(map, left, right, top, bottom, 0);
    } else {
      compress(map, left, right, top, bottom, threshold);
    }

    //System.out.println("Threshold " + (threshold/100.0));
    //System.out.println("Quadrant size: " + quadrantSize);
    //System.out.println("Zeros: " + (zeroCounter/quadrantSize*10));
    //System.out.println("Ones: " + (oneCounter/quadrantSize*10));

  }

  private static void paint(char[][] map, int left, int right, int top, int bottom, int color) {
    char cColor = color == 1 ? '1' : '0';

    for (int i = top; i <= bottom; i++) {
      for (int j = left; j <= right; j++) {
        map[i][j] = cColor;
      }
    }
  }
}
