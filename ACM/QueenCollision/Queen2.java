import java.util.*;

public class Queen2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;){
            int boardSize = input.nextInt();
            if(boardSize == 0) break;
            int numLines = input.nextInt();
            Line[] lines = new Line[numLines];
            for(int i = 0; i < numLines; i++) {
                lines[i] = new Line(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
            }

            int[] columns = new int[boardSize];
            int[] rows = new int[boardSize];
            int[] lrDiag = new int[(boardSize*2)+1];
            int[] rlDiag = new int[(boardSize*2)+1];

            int queenCounter = 0;
            for(Line l : lines) {
                queenCounter += l.k;
            }

            ArrayList<QueenObj> queens = new ArrayList<QueenObj>(queenCounter);
            for (Line l : lines) {
                for(int i = 0; i < l.k; i++) {
                    queens.add(new QueenObj(l.x + (i*l.s)-1, l.y + (i*l.t)-1, boardSize));
                }
            }

            for (QueenObj q : queens) {
                columns[q.x] = columns[q.x] + 1;
                rows[q.y]++;
                lrDiag[q.lrdiag]++;
                rlDiag[q.rldiag]++;
            }

            int collisionCounter = 0;
            for(int i : columns)
                if(i > 1)
                    collisionCounter += i - 1;
            for(int i : rows)
                if(i > 1)
                    collisionCounter += i - 1;
            for(int i : lrDiag)
                if(i > 1)
                    collisionCounter += i - 1;
            for(int i : rlDiag)
                if(i > 1)
                    collisionCounter += i - 1;

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

class QueenObj {
    int x;
    int y;
    int lrdiag;
    int rldiag;

    public QueenObj(int xArg, int yArg, int boardSize) {
        this.x = xArg;
        this.y = yArg;
        this.lrdiag = x + y;
        this.rldiag = Math.abs(boardSize+1-x) + y;
    }
}