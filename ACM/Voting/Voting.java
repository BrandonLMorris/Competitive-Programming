import java.util.*;

public class Voting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        for(; !line.equals("#"); line = input.nextLine()) {
            int total = 0;
            int yes = 0;
            int no = 0;
            int absent = 0;
            
            for(int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                total++;
                if (c == 'Y') {
                    yes++;
                } else if (c == 'N') {
                    no++;
                } else if (c == 'A') {
                    absent++;
                }
            }

//            System.out.println("Yes: " + yes + " No: " + no + " absent: " + absent + " total: " + total);

            if (absent >= (total/2.0)) {
                System.out.println("need quorum");
                continue;
            } 

            if (yes > no) {
                System.out.println("yes");
            } else if (yes < no) {
                System.out.println("no");
            } else {
                System.out.println("tie");
            }

        }
    }
}
