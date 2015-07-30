import java.util.*;

public class Queen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int boardSize = input.nextInt();
            if(boardSize == 0) break;
            int numLines = input.nextInt();
            Line[] lines = new Line[numLines];
            for(int i = 0; i < numLines; i++) {
                lines[i] = new Line(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
            }

            boolean[][] board = new boolean[boardSize][boardSize];

            //Place all the queens on the board
            for (Line line : lines) {
                for(int i = 0; i < line.k; i++) {
                    board[line.y + (i*line.t)-1][line.x + (i*line.s)-1] = true;
                }
            }

            //Print board
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    System.out.print(board[i][j] ? 'Q' : '*');
                }
                System.out.println();
            }


            int collisionCounter = 0;
            //Check each column for vertical collisions
            for (int i = 0; i < boardSize; i++) {
                int queenCounter = 0;
                for (int j = 0; j < boardSize; j++) {
                    if(board[i][j])
                        queenCounter++;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }

            //Check each row for horizontal collisions
            for (int j = 0; j < boardSize; j++) {
                int queenCounter = 0;
                for (int i = 0; i < boardSize; i++) {
                    if (board[i][j])
                        queenCounter++;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }


            //Check each diagonal left to right for diagonal collisions
            for (int rowStart = 0; rowStart < boardSize; rowStart++) {
                int queenCounter = 0;
                int j = rowStart;
                int i = boardSize-1;
                while (i >= 0 && j >= 0) {
                    if (board[i][j])
                        queenCounter++;
                    i--;
                    j--;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }
            for (int colStart = boardSize-1; colStart >= 0; colStart--) {
                int queenCounter = 0;
                int i = colStart;
                int j = boardSize-1;
                while (i >= 0 && j >= 0) {
                    if (board[i][j])
                        queenCounter++;
                    i--;
                    j--;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }

            //Check each diagonal right to left for diagonal collisions
            for (int rowStart = 0; rowStart > boardSize; rowStart++) {
                int queenCounter = 0;
                int j = rowStart;
                int i = 0;
                while (i >= 0 && j < boardSize) {
                    if (board[i][j])
                        queenCounter++;
                    i--;
                    j++;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }
            for (int colStart = 0; colStart < boardSize; colStart++) {
                int queenCounter = 0;
                int i = colStart;
                int j = boardSize - 1;
                while (i >= 0 && j < boardSize) {
                    if (board[i][j])
                        queenCounter++;
                    i--;
                    j++;
                }
                if (queenCounter > 1)
                    collisionCounter += (queenCounter - 1);
            }

            System.out.println(collisionCounter);
        }
    }
}

class Line {
    int k;
    int x;
    int y;
    int s;
    int t;
    
    public Line(int kArg, int xArg, int yArg, int sArg, int tArg) {
        this.k = kArg;
        this.x = xArg;
        this.y = yArg;
        this.s = sArg;
        this.t = tArg;
    }
}
