import java.util.*;

/* There are three mailbox containers, each with 9 different mailboxes. It 
 * takes Donald one step to move between adjacent mailboxes. Count the total
 * number of steps Donald needs to take to deliver all the mail.
 */

public class Donald {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // Read the number of names
    int n = Integer.parseInt(in.nextLine());

    // Intialize the counter and starting position
    int counter = 0;
    int pos = 0;

    // Iterate through each name, keeping track of the total steps
    for (int i = 0; i < n; i++) {
      int loc = location(in.nextLine());
      counter += Math.abs(pos - loc);
      pos = loc;
    }

    // Output the result
    System.out.println(counter);
  }

  // Helper method to return the location of a mailbox given the recipient's
  // name
  private static int location(String name) {
    switch (name) {
      case "Alice": return 0;
      case "Ariel": return 0;
      case "Aurora": return 0;
      case "Phil": return 0;
      case "Peter": return 0;
      case "Olaf": return 0;
      case "Phoebus": return 0;
      case "Ralph": return 0;
      case "Robin": return 0;
      case "Bambi": return 1;
      case "Belle": return 1;
      case "Bolt": return 1;
      case "Mulan": return 1;
      case "Mowgli": return 1;
      case "Mickey": return 1;
      case "Silver": return 1;
      case "Simba": return 1;
      case "Stitch": return 1;
      case "Dumbo": return 2;
      case "Genie": return 2;
      case "Jiminy": return 2;
      case "Kuzko": return 2;
      case "Kida": return 2;
      case "Kenai": return 2;
      case "Tarzan": return 2;
      case "Tiana": return 2;
      case "Winnie": return 2;
    }

    // Something went wrong if execution ever reaches here
    return Integer.MAX_VALUE;
  }
}
