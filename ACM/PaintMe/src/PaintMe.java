//SER2012 Div 2 E: "Paint Me"
//ACM 9/4/14
/**The solution to the Paint Me ACM ICPC Problem
*/

import java.util.*;

public class PaintMe {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numApart = input.nextInt();
        while (numApart != 0) {
            int width = input.nextInt();
            int length = input.nextInt();
            int height = input.nextInt();
            int areaPerCan = input.nextInt();
            int numWindowsAndDoors = input.nextInt();

            int windowAndDoorArea = 0;
            for(int i = 0; i < numWindowsAndDoors; i++){
                int winWidth = input.nextInt();
                int winHeight = input.nextInt();
                windowAndDoorArea += (winHeight * winWidth);
            }

            int totalArea = ((width * height * 2) + (length * height * 2) + (width * length) - (windowAndDoorArea)) * numApart;
            int numCans = totalArea / areaPerCan;
            if (totalArea % areaPerCan != 0){
                numCans++;
            }

            System.out.println(numCans);


            numApart = input.nextInt();
        }
    }
}
