import java.util.*;

public class Cakminator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows = Integer.parseInt(input.next());
        int cols = Integer.parseInt(input.next());
        boolean[] cannotEatRows = new boolean[rows];
        boolean[] cannotEatCols = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            char[] line = input.next().toCharArray();
            for (int j = 0; j < cols; j++) {
                if (line[j] == 'S') {
                    cannotEatRows[i] = true;
                    cannotEatCols[j] = true;
                }
            }
        }

        int counter = 0;
        int rowCounter = 0;
        for (boolean b : cannotEatCols) {
            if (!b) {
                //System.out.println("Adding a col");
                counter += rows;
                rowCounter++;
            }
        }
        int colCounter = 0;
        for (boolean b : cannotEatRows) {
            if (!b) {
                //System.out.println("Adding a row");
                counter += cols;
                colCounter++;
            }
        }
        //System.out.println("counter: " + counter + " rowCounter " + rowCounter + " colCounter: " + colCounter);
        counter -= (rowCounter*colCounter);
        System.out.println(counter);
    }
}
