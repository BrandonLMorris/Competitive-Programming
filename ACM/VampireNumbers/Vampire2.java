import java.util.*;

public class Vampire2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            int number = input.nextInt();
            if (number == 0) break;

            for (; !isVampire(number); number++);
            System.out.println(number);
        }
    }

    private static String getSig(int num) {
        char[] cArr = ((Integer)num).toString().toCharArray();
        Arrays.sort(cArr);
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static String getSig(int num1, int num2) {
        StringBuilder sb = new StringBuilder(((Integer)num1).toString());
        sb.append(num2);
        return getSig(Integer.parseInt(sb.toString()));
    }

    private static boolean isVampire(int number) {
        String numSig = getSig(number);
        for (int i = 2; i*i < number; i++) {
            if (number % i != 0) continue;
            int quotient = number / i;
            if(getSig(i, quotient).equals(numSig))
                return true;
        }

        return false;
    }

}
