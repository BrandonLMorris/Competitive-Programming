/*Underground Cables ACM Problem
 *Presented by Zach Butcher
 *10/22
 */
import java.util.*;

public class UndergroundCables {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	for(;;){
	    int n = input.nextInt();
	    if(n == 0) return;

	    int[][] graph = new int[n][n];
	    for(int i = 0; i < n; i++) {


		ArrayList<Point> points = new ArrayList<Point>(n);

		for(int i = 0; i < n; i++) {
		    points.add(new Point(in.nextInt(), in.nextInt()));
		}
	    }
            for(int i = 0; i < points.size(); i++) {
                for(int j = i+1; j < points.size(); j++) {
                    graph[i][j] = points.get(i).distance(points.get(j));
                }
            }
	}
    }

    private static class Point {
	public int x;
	public int y;

	public double distance(Point p) {
	    int x = this.x + p.x;
	    int y = this.y + p.y;
	    return Math.sqrt(x * x + y * y);
	}
    }
}
