/**
 * Created by bmorris on 10/11/14.
 */
import java.util.*;

public class DigitSum{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        while(n != 0) {
            int[] values = new int[n];
            for (int i = 0; i < n; i++){
                values[i] = input.nextInt();
            }
            Arrays.sort(values);
            if(values[0] == 0){
                int i = 1;
                while (values[i] == 0){
                    i++;
                }
                values[0] = values[i];
                values[i] = 0;

            }
            if(values[1] == 0){
                int i = 2;
                while (values[i] == 0){
                    i++;
                }
                values[1] = values[i];
                values[i] = 0;
            }
            String str1 = "";
            String str2 = "";

            for(int i = 0; i < n; i+=2){
                str1 += String.valueOf(values[i]);
                if(i+1 < n){
                    str2 += String.valueOf(values[i+1]);
                }
            }
            int sum = Integer.parseInt(str1) + Integer.parseInt(str2);
            System.out.println(sum);

            n = input.nextInt();
        }
    }
}
