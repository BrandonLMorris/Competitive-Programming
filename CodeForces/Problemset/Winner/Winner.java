import java.util.*;

public class Winner {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int num = Integer.parseInt(input.next());

    ArrayList<Player> players = new ArrayList<Player>();

    for (int i = 0; i < num; i++) {
      players.add(new Player(input.next(), Integer.parseInt(input.next())));
    }

    Collections.sort(players);

    System.out.println(players.get(0).name);

  }
}

class Player implements Comparable<Player> {
  String name;
  int points;
  public Player(String nameArg, int pointsArg) {
    this.name = nameArg;
    this.points = pointsArg;
  }
  public int compareTo(Player p) {
    return -1 *(this.points - p.points);
  }
}
