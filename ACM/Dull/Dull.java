import java.util.*;

public class Dull {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    for (;;) {
      int numDulls = input.nextInt();
      if (numDulls == 0) break;
      int numPrograms = input.nextInt();
      int numStates = input.nextInt();
      Dll[] dulls = new Dll[numDulls];
      Program[] programs = new Program[numPrograms];
      input.nextLine();
      String line = input.nextLine();
      Scanner lScanner = new Scanner(line);
      for (int i = 0; lScanner.hasNext(); i++) {
        dulls[i] = new Dll((char)(i+'A'), Integer.parseInt(lScanner.next()));
      }
      for (int l = 0; l < numPrograms; l++) {
        line = input.nextLine();
        lScanner = new Scanner(line);
        int mem = Integer.parseInt(lScanner.next());
        ArrayList<Character> dlist = new ArrayList<Character>();
        String list = lScanner.next();
        for (int i = 0; i < list.length(); i++) {
          dlist.add(list.charAt(i));
        }
        programs[l] = new Program(mem, dlist);
      }

      int[] dullsInUse = new int[numDulls];
      int[] programsInUse = new int[numPrograms];
      long maxMemory = 0;
      String stateLine = input.nextLine();
      Scanner stateScanner = new Scanner(stateLine);
      while (stateScanner.hasNext()) {
        int prog = Integer.parseInt(stateScanner.next());
        if (prog > 0) {
          programsInUse[prog-1]++;
          for (char c : programs[prog-1].dllList) {
            dullsInUse[c-'A']++;
          }
          long memory = 0;
          for (int i = 0; i < numPrograms; i++) {
            if (programsInUse[i] > 0) {
              memory += programs[i].memory*programsInUse[i];
            }
          }
          for (int i = 0; i < numDulls; i++) {
            if(dullsInUse[i] > 0) {
              memory += dulls[i].memory;
            }
          }
          if (memory > maxMemory) {
            maxMemory = memory;
          }
        } else {
          prog = prog*(-1);
          programsInUse[prog-1]--;
          for (char c : programs[prog-1].dllList) {
            dullsInUse[c-'A']--;
          }
        }
      }
      System.out.println(maxMemory);
    }
  }
}

class Dll {
  char label;
  int memory;

  public Dll(char labelArg, int memoryArg) {
    this.label = labelArg;
    this.memory = memoryArg;
  }
}

class Program {
  int memory;
  ArrayList<Character> dllList;
  public Program(int memArg, ArrayList<Character> dllListArg) {
    this.memory = memArg;
    this.dllList = dllListArg;
  }
}
