import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Code {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int numTests = Integer.parseInt(in.readLine());
    for (int t = 0; t < numTests; t++) {

      int numEncryptedMessages = Integer.parseInt(in.readLine());
      String[] messages = new String[numEncryptedMessages];
      for (int i = 0; i < numEncryptedMessages; i++) {
        messages[i] = in.readLine();
      }
      String decryptedMessage = in.readLine();
      String messageToDecrypt = in.readLine();
      String[] decryptionResults = new String[messages.length];

      for (int i = 0; i < messages.length; i++) {
        HashMap<Character, Character> encryptToDecrypt = new HashMap<Character,
            Character>();
        HashMap<Character, Character> decryptToEncrypt = new HashMap<Character,
            Character>();

        if (messages[i].length() != decryptedMessage.length()) {
          decryptionResults[i] = null;
          continue;
        }

        boolean invalid = false;
        for (int j = 0; j < messages[i].length(); j++) {
          char e = messages[i].charAt(j);
          char d = decryptedMessage.charAt(j);
          if (encryptToDecrypt.get(e) != null && encryptToDecrypt.get(e) != d) {
            invalid = true;
            // System.out.println("Broke mapping e:"+e+" to d:"+d);
          } else {
            encryptToDecrypt.put(e, d);
          }
          if (decryptToEncrypt.get(d) != null && decryptToEncrypt.get(d) != e) {
            // System.out.println("Broke mapping e:"+e+" to d:"+d+" in decrypt to encrypt");
            invalid = true;
          } else {
            decryptToEncrypt.put(d, e);
          }
        }

        if (invalid) {
          decryptionResults[i] = null;
          continue;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < messageToDecrypt.length(); j++) {
          if (encryptToDecrypt.get(messageToDecrypt.charAt(j)) != null) {
            sb.append(encryptToDecrypt.get(messageToDecrypt.charAt(j)));
          } else {
            sb.append("?");
          }
        }

        decryptionResults[i] = sb.toString();
      }

      String result = null;
      for (String s : decryptionResults) {
        if (s != null) {
          result = s;
          break;
        }
      }

      if (result == null) {
        System.out.println("IMPOSSIBLE");
        continue;
      }

      char[] resultArr = result.toCharArray();
      for (String s : decryptionResults) {
        if (s == null) continue;
        for (int i = 0; i < s.length(); i++) {
          if (resultArr[i] == '?' || s.charAt(i) == '?') {
            resultArr[i] = '?';
          } else if (resultArr[i] != s.charAt(i)) {
            resultArr[i] = '?';
          }
        }
      }

      System.out.println(new String(resultArr));

    }
  }
}