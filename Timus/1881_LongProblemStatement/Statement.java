import java.util.*;

public class Statement {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int pageHeight = in.nextInt();
    int lineWidth = in.nextInt();
    int numWords = in.nextInt();

    int lineCount = 1;
    int widthCount = 0;
    int pageCount = 1;
    for (int i = 0; i < numWords; i++) {

      int nextWordLen = in.next().length();
      // System.err.println("Word len: " + nextWordLen);
      if (widthCount == 0) {
        widthCount += nextWordLen;

      } else if (widthCount + nextWordLen + 1 <= lineWidth) {
        widthCount += nextWordLen + 1;

      } else {
        lineCount++;
        widthCount = nextWordLen;

        if (lineCount > pageHeight) {
          pageCount++;
          lineCount = 1;
        }
      }
    }

    System.out.println(pageCount);
  }
}
