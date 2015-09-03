import java.util.*;

public class Number {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.next());

    ArrayList<String> peopleStr = new ArrayList<String>();
    Team[] teams = new Team[n];


    for (int i = 0; i < n; i++) {

      String s1 = in.next();
      String s2 = in.next();
      String s3 = in.next();

      // Add the team players to the name list if not in already
      if (!peopleStr.contains(s1)) peopleStr.add(s1);
      if (!peopleStr.contains(s2)) peopleStr.add(s2);
      if (!peopleStr.contains(s3)) peopleStr.add(s3);

      // Store the team
      teams[i] = new Team(s1, s2, s3);
    }

    // Maps the name of the player to their distance from Isenbaev
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    // Maps the name of the player to their index in the people list
    // (pre-sorted)
    HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
    // Store the list of people
    ArrayList<Person> people = new ArrayList<Person>();
    for (int i = 0; i < peopleStr.size(); i++) {
      hm.put(peopleStr.get(i), i);
      people.add(new Person(peopleStr.get(i)));
      indexMap.put(peopleStr.get(i), people.size()-1);
    }

    // Add the teammates for each player (create the adjacency lists)
    for (int i = 0; i < teams.length; i++) {
      int p1index = indexMap.get(teams[i].person1);
      int p2index = indexMap.get(teams[i].person2);
      int p3index = indexMap.get(teams[i].person3);

      if (!people.get(p1index).teammates.contains(people.get(p2index))) {
        people.get(p1index).teammates.add(people.get(p2index));
      }
      if (!people.get(p1index).teammates.contains(people.get(p3index))) {
        people.get(p1index).teammates.add(people.get(p3index));
      }
      if (!people.get(p2index).teammates.contains(people.get(p1index))) {
        people.get(p2index).teammates.add(people.get(p1index));
      }
      if (!people.get(p2index).teammates.contains(people.get(p3index))) {
        people.get(p2index).teammates.add(people.get(p3index));
      }
      if (!people.get(p3index).teammates.contains(people.get(p1index))) {
        people.get(p3index).teammates.add(people.get(p1index));
      }
      if (!people.get(p3index).teammates.contains(people.get(p2index))) {
        people.get(p3index).teammates.add(people.get(p2index));
      }
    }

    // Map the players to their distance
    for (int i = 0; i < people.size(); i++) {
      hm.put(people.get(i).name, getDistance(people.get(i)));
    }

    // Sort the names alphabetically and print the result
    Collections.sort(people);
    for (Person p : people) {
      int num = hm.get(p.name);
      System.out.println(p.name + " " + (num == -1 ?  "undefined" : num));
    }

  }

  // Perform the actual bfs
  static int getDistance(Person person) {
    // Simple case
    if (person.name.equals("Isenbaev")) {
      return 0;
    } else {

      // Maintain list of visited players
      HashSet<Person> visited = new HashSet<Person>();
      // Represents the current level
      LinkedList<Person> currentQueue = new LinkedList<Person>(
          person.teammates);
      // Represents the next level
      LinkedList<Person> nextQueue = new LinkedList<Person>();
      // Number of the current level
      int count = 1;

      // Two loops: one for all the levels, inner for the current level
      while (!currentQueue.isEmpty()) {
        while (!currentQueue.isEmpty()) {
          Person p = currentQueue.removeFirst();
          visited.add(p);
          if (p.name.equals("Isenbaev")) {
            return count;
          }
          for (Person n : p.teammates) {
            if (!visited.contains(n))
              nextQueue.add(n);
          }
        }

        // Switch the current queue to the next queue
        currentQueue = new LinkedList<Person>(nextQueue);
        nextQueue = new LinkedList<Person>();
        count++;
      }
    }
    // Didn't find it, so -1
    return -1;
  }

  // Encapsulates a person: their name and list of teammates
  private static class Person implements Comparable<Person>{
    String name;
    ArrayList<Person> teammates;

    public Person(String n) {
      this.name = n;
      teammates = new ArrayList<Person>();
    }

    public int compareTo(Person other) {
      return this.name.compareTo(other.name);
    }

    public boolean equals(Object o) {
      if (o instanceof Person) {
        return this.name == ((Person)o).name;
      }
      return false;
    }
  }

  // Simple triple to hold the teams
  private static class Team {
    String person1;
    String person2;
    String person3;

    public Team(String s1, String s2, String s3) {
      this.person1 = s1;
      this.person2 = s2;
      this.person3 = s3;
    }

  }
}
