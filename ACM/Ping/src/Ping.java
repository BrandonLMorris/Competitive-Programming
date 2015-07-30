/**
 * Created by bmorris on 11/25/14.
 */
import java.util.*;

public class Ping {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] signal = input.nextLine().toCharArray();
        while(signal[0] != 0 && signal.length > 1) {
            String output = "";
            
            for(int i = 1; i < signal.length; i++) {
                if(signal[i] == '1') {
                    if(output.equals("")) {
                        output += Integer.toString(i);
                    } else {
                        output += " " + Integer.toString(i);
                    }

                    for(int j = i; j < signal.length; j += i) {
                        signal[j] = (signal[j] == '1') ? '0' : '1';
                    }
                }
            }
            output = output.trim();
            System.out.println(output);
            
            signal = input.nextLine().toCharArray();
        }
    }
}
