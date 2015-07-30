import java.util.*;

public class TimeCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = input.nextInt();
        for(int t = 0; t < numTests; t++) {
            int startHr = input.nextInt();
            int startMin = input.nextInt();
            int durHr = input.nextInt();
            int durMin = input.nextInt();

            int numHours = durHr + 1;
            if(durMin + startMin >= 60)
                numHours++;

            printFirst();
            for(int i = 0; i < numHours; i++) {
                int curHour = startHr + i;
                if(curHour > 12)
                    curHour -= 12;
                if (i == 0) {
                    printTimeLine(curHour, 0, true, startMin);
                } else {
                    int adjustment = (i*60) - startMin;
                    printTimeLine(curHour, adjustment, false, startMin);
                }
            }

        }
    }

    private static void printFirst() {
        System.out.println("------+---------");
        System.out.println(" time | elapsed ");
        System.out.println("------+---------");
    }

    private static void printTimeLine(int hour, int adjustment, boolean isFirst, int startMinute) {
        StringBuilder line = new StringBuilder();
        if(isFirst) {
            if(hour < 10) {
                line.append(" " + hour);
            } else {
                line.append(hour);
            }
            line.append(":XX | XX");
            if(startMinute != 0) {
                line.append(" - " + startMinute);
            }
        } else {
            if(hour < 10) {
                line.append(" " + hour);
            } else {
                line.append(hour);
            }
            line.append(":XX | XX + " + adjustment);
        }
        System.out.println(line.toString());
    }

}
