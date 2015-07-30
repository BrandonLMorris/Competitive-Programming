import java.util.*;

public class Cloud {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (int t = 1;; t++) {
      int w = Integer.parseInt(input.next());
      int n = Integer.parseInt(input.next());
      if (w == 0) break;

      ArrayList<Word> words = new ArrayList<Word>();
      int mostOccurances = 0;

      for (int i = 0; i < n; i++) {
        Word word = new Word(input.next(), Integer.parseInt(input.next()));
        if (word.frequency > mostOccurances) mostOccurances = word.frequency;
        words.add(word);
      }

      for (Word word : words) {
        word.calcSize(mostOccurances);
      }

      int totalHeight = 0;
      int currentHeight = 0;
      int currentWidth = 0;
      for (Word word : words) {
        if (currentWidth == 0) {
          currentWidth = word.width;
          currentHeight = word.height;
        } else if (w >= currentWidth + 10 + word.width) {
          currentWidth += 10 + word.width;
          if (word.height > currentHeight)
            currentHeight = word.height;
        } else {
          totalHeight += currentHeight;
          currentHeight = word.height;
          currentWidth = word.width;
        }
      }
      totalHeight += currentHeight;

      System.out.println("CLOUD " + t + ": " + totalHeight);

    }
  }

  private static class Word {
    String word;
    int frequency;
    int height;
    int width;
    public Word(String wordArg, int frequencyArg) {
      this.word = wordArg;
      this.frequency = frequencyArg;
    }
    public void calcSize(int maxOccur) {
      this.height = 8 + (int)Math.ceil((40*(this.frequency-4))/(double)(maxOccur-4));
      this.width = (int)Math.ceil((9.0/16)*this.word.length()*this.height);
    }
  }
}
