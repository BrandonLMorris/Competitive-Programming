/**
 * Created by bmorris on 10/11/14.
 * Program desinged by Drew Hoover
 */
import java.util.*;

public class SortMe {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int year = 1;

        for (;;) {					//forever
            String output = "";
            int n = s.nextInt();
            if (n == 0) break;
            String perm = s.nextLine().trim();		//Given alphabet by which to sort
            String temp = s.nextLine().trim();		//first in list of words
            output += temp;
            for (int i = 1; i < n; i++) {
                temp = s.nextLine().trim();
                Scanner scan = new Scanner(output);
                scan.useDelimiter("\n");
                boolean added = false;
                while (scan.hasNext() && added == false) {
                    String temp2 = scan.next();
                    if (temp.equals(temp2)) {
                        output = output.substring(0, output.indexOf(temp2)) + temp + "\n" + output.substring(output.indexOf(temp2));
                        added = true;
                    } else if (isLessThan(temp, temp2, perm)) {
                        output = output.substring(0, output.indexOf(temp2)) + temp + "\n" + output.substring(output.indexOf(temp2));
                        added = true;
                    }
                }
                if (added == false) {
                    output += "\n" + temp;
                }
            }
            System.out.println("year " + year++);
            System.out.println(output);
        }
    }

    //Compares the index of each character within the given alphabet
    //Uses string length to break ties (i.e. "HOW" and "HOWEVER")
    public static boolean isLessThan(String s1, String s2, String perm) {
        int shortestStr = (s1.length() > s2.length()) ? s2.length() : s1.length();
        for (int i = 0; i < shortestStr; i++) {
            char A = s1.charAt(i);
            char B = s2.charAt(i);
            if (perm.indexOf(A) > perm.indexOf(B)) {
                return false;
            } else if (perm.indexOf(A) < perm.indexOf(B)) {
                return true;
            }
        }
        return (s1.length() < s2.length()) ? true : false;
    }
}
