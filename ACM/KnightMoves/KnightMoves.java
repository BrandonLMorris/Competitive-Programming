import java.util.*;

public class KnightMoves {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        Scanner stringScanner = new Scanner(firstLine);
        int rows = stringScanner.nextInt();
        int cols = stringScanner.nextInt();
        //System.out.println("Rows: " + rows);
        //System.out.println("Cols: " + cols);
        int moves;
        Point root = null;
        Point king = null;

        Point[][] board = new Point[rows][cols];
       
        for(int i = 0; i < rows; i++) {
            String line = input.nextLine();
            //System.out.println(line);
            for(int j = 0; j < cols; j++) {
                char boardPos = line.charAt(j);
                board[i][j] = new Point(boardPos, i, j);
                if(boardPos == 'X') {
                    root = board[i][j];
                    root.beenChecked = true;
                }
            }
        }
        //System.out.println("Knight is located at " + root.row + " " + root.col);

        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(root);
        while(!(queue.isEmpty())) {
            //Check if point is the king space
            //if not, add all valid moves to the queue
            Point current = queue.remove();
            //System.out.println("Current point is " + current.value);
            if(current.value == 'K') {
                king = current;
                break;
            }
            //Add valid moves
            addMoves(current, queue, board, rows, cols);
        }
        if(king == null) {
            System.out.println(-1);
        } else {
           root.previous = null;
           int counter = 0;
           Point current = king;
           //System.out.println("King is at " + king.row + " " + king.col);
           while(current.previous != null) {
               current = current.previous;
               //System.out.println("Moving back to " + current.row + " " + current.col);
               counter++;
           }
           System.out.println(counter);
        }
    }

    public static void addMoves(Point current, LinkedList<Point> queue, Point[][] board, int rows, int cols) {
        int[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        //int[] yMoves = {};
        for(int[] m : moves) {
            int i = m[0];
            int j = m[1];
            //if(i == j || Math.abs(i) == Math.abs(j)) continue;
            if(current.row+i >= 0 && current.row+i < rows) {
                if(current.col+j >= 0 && current.col+j < cols) {
                    //System.out.println("Trying " + (current.row+i) + " " + (current.col+j));
                    if(board[current.row+i][current.col+j].value != '#' && !board[current.row+i][current.col+j].beenChecked) {
                        Point toAdd = board[current.row+i][current.col+j];
                        toAdd.beenChecked = true;
                        toAdd.previous = current;
                        queue.add(board[current.row+i][current.col+j]);
                        //System.out.println("Added " + toAdd.row + " " + toAdd.col);
                    }
                }
            }

        }
    }
}

class Point {
    char value;
    Point previous;
    boolean beenChecked;
    int row;
    int col;

    public Point(char val, int r, int c) {
        this.value = val;
        this.row = r;
        this.col = c;
    }
}
