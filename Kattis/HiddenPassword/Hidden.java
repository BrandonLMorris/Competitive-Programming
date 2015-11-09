import java.util.*;
import java.io.*;

public class Hidden {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    String password = st.nextToken();
    String message = st.nextToken();

    HashMap<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < password.length(); i++) {
      if (!counts.containsKey(password.charAt(i))) {
        counts.put(password.charAt(i), 1);
      } else {
        counts.put(password.charAt(i), counts.get(password.charAt(i))+1);
      }
    }

    boolean valid = true;
    int passPos = 0;
    for (int i = 0; i < message.length() && passPos < password.length(); i++) {
      // Check that the next letter is the next letter in the password
      if (message.charAt(i) == password.charAt(passPos)) {
        counts.put(password.charAt(passPos),
            counts.get(password.charAt(passPos))-1);

        // Remove it if no more occurrences (not strictly necessary)
        if (counts.get(password.charAt(passPos)) == 0) {
          counts.remove(password.charAt(passPos));
        }

        passPos++;
      } else if (counts.containsKey(message.charAt(i))) {
        valid = false;
        break;
      }
    }

    // Not valid if letters in our password we didn't get to
    if (passPos < password.length()) valid = false;

    System.out.println((valid ? "PASS" : "FAIL"));

  }
}