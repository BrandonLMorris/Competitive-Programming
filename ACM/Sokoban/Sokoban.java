import java.util.*;

public class Sokoban {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (int t = 1;; t++) {
      int numRows = input.nextInt();
      int numCols = input.nextInt();
      if (numRows == 0 && numCols == 0) break;
      input.nextLine();
      char[][] board = new char[numRows][numCols];

      ArrayList<Point> targets = new ArrayList<Point>();
      int workerRow = 0;
      int workerCol = 0;

      // Row i, column j
      for (int i = 0; i < numRows; i++) {
        String line = input.nextLine();
        for (int j = 0; j < numCols; j++) {
          board[i][j] = line.charAt(j);
          if (board[i][j] == '+' || board[i][j] == 'B') {
            targets.add(new Point(i, j));
          } else if (board[i][j] == 'w') {
            workerRow = i;
            workerCol = j;
          } else if (board[i][j] == 'W') {
            workerRow = i;
            workerCol = j;
            targets.add(new Point(i,j));
          }
        }
      }

      String moveLine = input.nextLine();

      boolean gameComplete = false;
      for (int c = 0; c < moveLine.length(); c++) {
        // Player can move up, down, left or right
        char move = moveLine.charAt(c);

        //System.out.println("\nProcessing move " + move);

        // Handle downward movement
        if (move == 'D') {
          // If position above is empty, just move worker up
          if (workerRow + 1 < numRows && (board[workerRow+1][workerCol] == '.' || board[workerRow+1][workerCol] == '+')) {
            // Move 'w' to that position
            if (board[workerRow+1][workerCol] == '.') {
              board[workerRow+1][workerCol] = 'w';
            } else {
              board[workerRow+1][workerCol] = 'W';
            }

            // Set old position to '.' or '+', depending if it was a target location
            if (board[workerRow][workerCol] == 'W') {
              board[workerRow][workerCol] = '+';
            } else {
              board[workerRow][workerCol] = '.';
            }

            // Reset worker position
            workerRow += 1;
          }

          // If position above has a box there, check if able to push box
          else if (workerRow + 1 < numRows && (board[workerRow+1][workerCol] == 'b' || board[workerRow+1][workerCol] == 'B')) {
            // Can only move box if other space is empty or a target space
            if (workerRow + 2 < numRows && (board[workerRow+2][workerCol] == '.' || board[workerRow+2][workerCol] == '+')) {
              // Move the box
              if (board[workerRow+2][workerCol] == '+') {
                board[workerRow+2][workerCol] = 'B';
              } else {
                board[workerRow+2][workerCol] = 'b';
              }
              // Move the worker
              if (board[workerRow+1][workerCol] == 'b') {
                board[workerRow+1][workerCol] = 'w';
              } else {
                board[workerRow+1][workerCol] = 'W';
              }
              if (board[workerRow][workerCol] == 'W') {
                board[workerRow][workerCol] = '+';
              } else {
                board[workerRow][workerCol] = '.';
              }
              // Reset worker position
              workerRow++;
            }
          }
        }

        // HANDLE upward MOVEMENT
        if (move == 'U') {
          // If position above is empty, just move worker up
          if (workerRow - 1 >= 0 && (board[workerRow-1][workerCol] == '.' || board[workerRow-1][workerCol] == '+')) {
            // Move 'w' to that position
            if (board[workerRow-1][workerCol] == '.') {
              board[workerRow-1][workerCol] = 'w';
            } else {
              board[workerRow-1][workerCol] = 'W';
            }

            // Set old position to '.' or '+', depending if it was a target location
            if (board[workerRow][workerCol] == 'W') {
              board[workerRow][workerCol] = '+';
            } else {
              board[workerRow][workerCol] = '.';
            }

            // Reset worker position
            workerRow -= 1;
          }
          // If position above has a box there, check if able to push box
          else if (workerRow - 1 >= 0 && (board[workerRow-1][workerCol] == 'b' || board[workerRow-1][workerCol] == 'B')) {
            // Can only move box if other space is empty or a target space
            if (workerRow - 2 >= 0 && (board[workerRow-2][workerCol] == '.' || board[workerRow-2][workerCol] == '+')) {
              // Move the box
              if (board[workerRow-2][workerCol] == '+') {
                board[workerRow-2][workerCol] = 'B';
              } else {
                board[workerRow-2][workerCol] = 'b';
              }
              // Move the worker
              if (board[workerRow-1][workerCol] == 'b') {
                board[workerRow-1][workerCol] = 'w';
              } else {
                board[workerRow-1][workerCol] = 'W';
              }
              if (board[workerRow][workerCol] == 'W') {
                board[workerRow][workerCol] = '+';
              } else {
                board[workerRow][workerCol] = '.';
              }
              // Reset worker position
              workerRow--;
            }
          }
        }

        // HANDLE LEFT MOVEMENT
        if (move == 'L') {
          // If position above is empty, just move worker up
          if (workerCol - 1 >= 0 && (board[workerRow][workerCol-1] == '.' || board[workerRow][workerCol-1] == '+')) {
            // Move 'w' to that position
            if (board[workerRow][workerCol-1] == '.') {
              board[workerRow][workerCol-1] = 'w';
            } else {
              board[workerRow][workerCol] = 'W';
            }
            // Set old position to '.' or '+', depending if it was a target location
            if (board[workerRow][workerCol] == 'W') {
              board[workerRow][workerCol] = '+';
            } else {
              board[workerRow][workerCol] = '.';
            }
            // Reset worker position
            workerCol -= 1;
          }
          // If position above has a box there, check if able to push box
          else if (workerCol - 1 >= 0 && (board[workerRow][workerCol-1] == 'b' || board[workerRow][workerCol-1] == 'B')) {
            // Can only move box if other space is empty or a target space
            if (workerCol - 2 >= 0 && (board[workerRow][workerCol-2] == '.' || board[workerRow][workerCol-2] == '+')) {
              // Move the box
              if (board[workerRow][workerCol-2] == '+') {
                board[workerRow][workerCol-2] = 'B';
              } else {
                board[workerRow][workerCol-2] = 'b';
              }
              // Move the worker
              if (board[workerRow][workerCol-1] == 'b') {
                board[workerRow][workerCol-1] = 'w';
              } else {
                board[workerRow][workerCol-1] = 'W';
              }
              if (board[workerRow][workerCol] == 'W') {
                board[workerRow][workerCol] = '+';
              } else {
                board[workerRow][workerCol] = '.';
              }
              // Reset worker position
              workerCol--;
            }
          }
        }

        // HANDLE RIGHT MOVEMENT
        else if (move == 'R') {
          // If position above is empty, just move worker up
          if (workerCol + 1 < numCols && (board[workerRow][workerCol+1] == '.' || board[workerRow][workerCol+1] == '+')) {
            // Move 'w' to that position
            if (board[workerRow][workerCol+1] == '.') {
              board[workerRow][workerCol+1] = 'w';
            } else {
              board[workerRow][workerCol+1] = 'W';
            }
            // Set old position to '.' or '+', depending if it was a target location
            if (board[workerRow][workerCol] == 'W') {
              board[workerRow][workerCol] = '+';
            } else {
              board[workerRow][workerCol] = '.';
            }
            // Reset worker position
            workerCol += 1;
          }
          // If position above has a box there, check if able to push box
          else if (workerCol + 1 < numCols && (board[workerRow][workerCol+1] == 'b' || board[workerRow][workerCol+1] == 'B')) {
            // Can only move box if other space is empty or a target space
            if (workerCol + 2 < numCols && (board[workerRow][workerCol+2] == '.' || board[workerRow][workerCol+2] == '+')) {
              // Move the box
              if (board[workerRow][workerCol+2] == '+') {
                board[workerRow][workerCol+2] = 'B';
              } else {
                board[workerRow][workerCol+2] = 'b';
              }
              // Move the worker
              if (board[workerRow][workerCol+1] == 'b') {
                board[workerRow][workerCol+1] = 'w';
              } else {
                board[workerRow][workerCol+1] = 'W';
              }
              if (board[workerRow][workerCol] == 'W') {
                board[workerRow][workerCol] = '+';
              } else {
                board[workerRow][workerCol] = '.';
              }
              // Reset worker position
              workerCol++;
            }
          }
        }

        // for (int r = 0; r < numRows; r++) {
        //   for (int s = 0; s < numCols; s++) {
        //     System.out.print(board[r][s]);
        //   }
        //   System.out.println();
        // }

        boolean uncoveredTargetExists = false;
        for (Point p : targets) {
          if (board[p.row][p.col] != 'B') {
            uncoveredTargetExists = true;
            break;
          }
        }

        if (!uncoveredTargetExists) {
          gameComplete = true;
          //System.out.println("Game completed");
          break;
        }

      }

      // Print out the result
      System.out.println("Game " + t + ": " + (gameComplete ? "complete" : "incomplete")); 
      for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
          System.out.print(board[i][j]);
        }
        System.out.println();
      }


    }
  }
}

class Point {
  int row;
  int col;
  public Point(int rowArg, int colArg) {
    this.row = rowArg;
    this.col = colArg;
  }
}
