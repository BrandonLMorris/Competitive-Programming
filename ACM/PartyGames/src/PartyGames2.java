import java.util.*;

public class PartyGames2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());
        while(n != 0) {
            String output = "";
            String c = "";

            ArrayList<String> names = new ArrayList<String>(n);
            for(int i = 0; i < n; i++) {
                names.add(input.nextLine());
            }
            Collections.sort(names);

            String name1 = names.get((n/2) -1);
            String name2 = names.get(n/2);

            for(int i = 0; i < name1.length(); i++) {
                char ch = name1.charAt(i);
                if(ch != 'Z' && i < name1.length()-1) {
                    ch++;
                }
                output = c + ch;
                if(name1.compareTo(output) <= 0 && name2.compareTo(output) > 0) {
                    break;
                } else {
                    c += name1.charAt(i);
                }
            }

            System.out.println(output);

            n = Integer.parseInt(input.nextLine());
        }
    }
}
