import java.util.*;

public class BuildingAList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTests = Integer.parseInt(input.nextLine());
        for(int t = 0; t < numTests; t++) {
            int stringSize = Integer.parseInt(input.nextLine());
            char[] charArr = input.nextLine().toCharArray();
            for(int i = 0; i < charArr.length; i++) {
                StringBuffer sb = new StringBuffer();
                for(int j = i; j < charArr.length; j++) {
                   sb.append(charArr[j]);
                   System.out.println(sb);
                }
            }
        }
    }
}
