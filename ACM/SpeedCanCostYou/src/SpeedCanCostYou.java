/**
 * P9
 * Speed Can Cost You
 * ACM ICPC 2013 I
 * Created by bmorris on 9/17/14.
 */

import java.util.*;

public class SpeedCanCostYou {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int d = input.nextInt();
        int s1 = input.nextInt();
        int s2 = input.nextInt();

        while(d != 0){
            double timeDifference = ((double)d/s1) - ((double)d/s2);

            int hours = (int)Math.floor(timeDifference);
            int minutes = (int)((timeDifference - hours) * 60);
            int seconds = (int)Math.round(((timeDifference - hours) - (minutes/60.0f))*3600);

            String minutesString;
            String secondsString;
            if(minutes < 10){
                minutesString = "0" + Integer.toString(minutes);
            } else {
                minutesString = Integer.toString(minutes);
            }
            if(seconds < 10){
                secondsString = "0" + Integer.toString(seconds);
            } else {
                secondsString = Integer.toString(seconds);
            }

            System.out.println(Integer.toString(hours) + ":" + minutesString + ":" + secondsString);



            d = input.nextInt();
            s1 = input.nextInt();
            s2 = input.nextInt();
        }

    }

}
