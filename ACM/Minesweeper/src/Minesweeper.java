/**
 * Created by bmorris on 11/23/14.
 */
import java.util.*;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        Scanner lineScanner = new Scanner(line);
        int rows = Integer.parseInt(lineScanner.next());
        int cols = Integer.parseInt(lineScanner.next());

        while(rows != 0) {
            char[][] board = new char[rows][cols];
            //String boardLine = input.nextLine();
            for(int i = 0; i < rows; i++){
                String boardLine = input.nextLine();
                for(int j = 0; j < cols; j++){
                    board[i][j] = boardLine.charAt(j);
                }
            }

            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if(board[i][j] != '*'){
                        board[i][j] = Integer.toString(numBombs(board, i, j, rows, cols)).charAt(0);
                    }
                }
            }

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    System.out.print(board[i][j]);
                }
                System.out.print('\n');
            }

            line = input.nextLine();
            lineScanner = new Scanner(line);
            rows = Integer.parseInt(lineScanner.next());
            cols = Integer.parseInt(lineScanner.next());
        }

    }

    public static int numBombs(char[][] board, int i, int j, int rows, int cols){
        //Counts the number of bombs ('*') surrounding the given location
        //Must be within bounds (the given location is not a bomb is a precondition)
        int bombCounter = 0;
        //left directions
        if(i - 1 >= 0 && i - 1 < rows) {
            if(board[i-1][j] == '*'){
                bombCounter++;
            }
            if(j - 1 >= 0 && j - 1< cols) {
                if(board[i-1][j-1] == '*'){
                    bombCounter++;
                }
            }
            if(j + 1 < cols) {
                if(board[i-1][j+1] == '*'){
                    bombCounter++;
                }
            }
        }
        //right directions
        if(i + 1 < rows) {
            if(board[i+1][j] == '*'){
                bombCounter++;
            }
            if(j + 1 < cols) {
                if(board[i+1][j+1] == '*') {
                    bombCounter++;
                }
            }
            if(j - 1 >= 0 && j-1 < cols){
                if(board[i+1][j-1] == '*') {
                    bombCounter++;
                }
            }
        }
        //straight left and right
        if(j + 1 < cols) {
            if(board[i][j+1] == '*') {
                bombCounter++;
            }
        }
        if(j - 1 >= 0){
            if(board[i][j-1] == '*') {
                bombCounter++;
            }
        }

        return bombCounter;
    }

}
