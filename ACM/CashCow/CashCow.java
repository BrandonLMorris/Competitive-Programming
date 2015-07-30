//package CashCow;
import java.util.*;

public class CashCow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;){    
            int numMoves = Integer.parseInt(input.nextLine());
            if(numMoves == 0) break;

            //Board organized by board[column][row]
            Point[][] board = new Point[10][12];

            //Create the board
            for(int row = 11; row >= 0; row--) {
                String line = input.nextLine();
                for(int col = 0; col < 10; col++) {
                    board[col][row] = new Point(line.charAt(col), col, row);
                }
            }

            //Set up pointers to each neighbor (makes BFS easier) 
            makeNeighbors(board);


            //Execute each move
            for(int i = 0; i < numMoves; i++) {
                //Read in the move
                String line = input.nextLine();
                Scanner lineScanner = new Scanner(line);
                int colMove = lineScanner.next().charAt(0) - 'a';
                int rowMove = lineScanner.nextInt() - 1;

                makeNeighbors(board);

                // System.out.println("Move on " + (colMove+1) + " " + (rowMove+1));
                // if(board[colMove][rowMove] != null) {
                //     System.out.println("Value: " + board[colMove][rowMove].value);
                //     if(board[colMove][rowMove].nextTop != null) {
                //         System.out.println("Top: " + board[colMove][rowMove].nextTop.value);
                //     } else {
                //         System.out.println("Top is null");
                //     }
                //     if(board[colMove][rowMove].nextBottom != null) {
                //         System.out.println("Bot: " + board[colMove][rowMove].nextBottom.value);
                //     } else {
                //         System.out.println("Bot is null");
                //     }
                //     if(board[colMove][rowMove].nextLeft != null) {
                //         System.out.println("Lef: " + board[colMove][rowMove].nextLeft.value);
                //     } else {
                //         System.out.println("Left is null");
                //     }
                //     if(board[colMove][rowMove].nextRight != null) {
                //         System.out.println("Rig: " + board[colMove][rowMove].nextRight.value);
                //     } else {
                //         System.out.println("Right is null");
                //     }
                // }

                if(isCluster(board, colMove, rowMove)) {
                    removeCluster(board, colMove, rowMove);
                    makeNeighbors(board);
                    moveDown(board);
                    makeNeighbors(board);
                    moveLeft(board);
                    makeNeighbors(board);
                }

                // System.out.println("Move " + i);
                // printBoard(board);
                // System.out.println("\n");                
            }

            int counter = 0;
            for(int row = 11; row >= 0; row--) {
                for(int col = 0; col < 10; col++) {
                    if(board[col][row] != null)
                        counter++;
                }
            }
            

            System.out.println(counter);

        }
    }

    private static boolean isCluster(Point[][] board, int column, int row) {
        Point p = board[column][row];
        //Selecting an empty space wastes a turn
        if(p == null) return false;
        //Cluster must have three or more circles to be valid and removed. Initial point counts as part of the cluster
        int counter = 1;
        boolean[][] visited = new boolean[10][12];
        visited[column][row] = true;
        //queue uses add/remove
        //Use BFS to determine if the move is a valid cluster
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(p);
        while(counter < 3 && !queue.isEmpty()) {
            Point current = queue.remove();
            if(current.nextTop != null && current.nextTop.value == p.value && !visited[current.nextTop.column][current.nextTop.row]) {
                counter++;
                queue.add(current.nextTop);
                visited[current.nextTop.column][current.nextTop.row] = true;
            }
            if(current.nextBottom != null && current.nextBottom.value == p.value && !visited[current.nextBottom.column][current.nextBottom.row]) {
                counter++;
                queue.add(current.nextBottom);
                visited[current.nextBottom.column][current.nextBottom.row] = true;
            }
            if(current.nextLeft != null && current.nextLeft.value == p.value && !visited[current.nextLeft.column][current.nextLeft.row]) {
                counter++;
                queue.add(current.nextLeft);
                visited[current.nextLeft.column][current.nextLeft.row] = true;
            }
            if(current.nextRight != null && current.nextRight.value == p.value && !visited[current.nextRight.column][current.nextRight.row]) {
                counter++;
                queue.add(current.nextRight);
                visited[current.nextRight.column][current.nextRight.row] = true;
            }
        }

        if(counter > 2)
            return true;
        else
            return false;
    }

    private static void removeCluster(Point[][] board, int column, int row) {
        Point p = board[column][row];  
        ArrayList<Point> pointsToRemove = new ArrayList<Point>(120);
        pointsToRemove.add(p);
        boolean[][] visited = new boolean[10][12];
        visited[column][row] = true;
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.add(p);
        while(!queue.isEmpty()) {
            Point current = queue.remove();
            if(current.value == p.value) pointsToRemove.add(current);
    
            //Top
            if(current.nextTop != null && current.nextTop.value == p.value && !visited[current.nextTop.column][current.nextTop.row]) {
                queue.add(current.nextTop);
                visited[current.nextTop.column][current.nextTop.row] = true;
            }

            //Bottom
            if(current.nextBottom != null && current.nextBottom.value == p.value && !visited[current.nextBottom.column][current.nextBottom.row]) {
                queue.add(current.nextBottom);
                visited[current.nextBottom.column][current.nextBottom.row] = true;
            }

            //Left
            if(current.nextLeft != null && current.nextLeft.value == p.value && !visited[current.nextLeft.column][current.nextLeft.row]) {
                queue.add(current.nextLeft);
                visited[current.nextLeft.column][current.nextLeft.row] = true;
            }

            //Right
            if(current.nextRight != null && current.nextRight.value == p.value && !visited[current.nextRight.column][current.nextRight.row]) {
                queue.add(current.nextRight);
                visited[current.nextRight.column][current.nextRight.row] = true;
            }
        }

        for(Point point : pointsToRemove) {
            board[point.column][point.row] = null;
        }
    }

    private static void moveDown(Point[][] board) {
        for(int col = 0; col < 10; col++) {
            for(int row = 0; row < 12; row++) {
                if(board[col][row] == null) 
                    continue;
                else {
                    int rowToMove = 0;
                    while(rowToMove < row && board[col][rowToMove] != null) {
                        rowToMove++;
                    }
                    if(board[col][rowToMove] == null) {
                        board[col][rowToMove] = board[col][row];
                        board[col][row] = null;
                    }
                }
            }
        }
    }

    private static void moveLeft(Point[][] board) {
        //Move left to right. If current column is empty, find next non-empty column (if exists) and copy to current column
        for(int col = 0; col < 9; col++) {
            if(isColumnEmpty(board, col)) {
                int colToCopy = -1;
                for(int i = col; i < 10; i++) {
                    if(!isColumnEmpty(board, i)){
                        colToCopy = i;
                        break;
                    }
                }
                if(colToCopy != -1) {
                    copyColumns(board, col, colToCopy);
                }
            }
        }
    }

    private static void makeNeighbors(Point[][] board) {
        for(int row = 0; row <12; row++) {
            for(int col = 0; col < 10; col++) {
                Point p = board[col][row];
                if(p == null) continue;
                if(col > 0 && board[col-1][row] != null) {
                    p.nextLeft = board[col-1][row];
                } else {
                    p.nextLeft = null;
                }
                if(col < 9 && board[col+1][row] != null) {
                    p.nextRight = board[col+1][row];
                } else {
                    p.nextRight = null;
                }
                if(row > 0 && board[col][row-1] != null) {
                    p.nextBottom = board[col][row - 1];
                } else {
                    p.nextBottom = null;
                }
                if(row < 11 && board[col][row+1] != null) {
                    p.nextTop = board[col][row + 1];
                } else {
                    p.nextTop = null;
                }
            }
        }

        //Reset the coloumn and row fields for each point
        for(int row = 0; row < 12; row++) {
            for(int col = 0; col < 10; col++) {
                Point current = board[col][row];
                if(current != null) {
                    current.column = col;
                    current.row = row;
                }
            }
        }
    }
    
    private static void printBoard(Point[][] board) {
        for(int row = 11; row >= 0; row--) {
            for(int col = 0; col < 10; col++) {
                if(board[col][row] == null)
                    System.out.print('-');
                else System.out.print(board[col][row].value);
            }
            System.out.println();
        }
    }

    private static boolean isColumnEmpty(Point[][] board, int column) {
        boolean isEmpty = true;
        for(int i = 0; i < 11; i++) {
            if(board[column][i] != null)
                isEmpty = false;
        }
        return isEmpty;
    }

    private static void copyColumns(Point[][] board, int newColumn, int copyColumn) {
        //newColumn is the column being copied into, copyColumn is the column being copied from
        for(int i = 0; i < 12; i++) {
            board[newColumn][i] = board[copyColumn][i];
            board[copyColumn][i] = null;
        }
    }
}

class Point {
    char value;
    int column;
    int row;
    Point nextTop;
    Point nextBottom;
    Point nextLeft;
    Point nextRight;

    public Point(char c, int colArg, int rowArg) {
        this.value = c;
        this.column = colArg;
        this.row = rowArg;
    }
}