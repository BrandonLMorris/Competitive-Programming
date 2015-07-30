import java.util.*;

public class Vampire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //final int BIGGEST_VAMP = 1000255;
        //boolean[] vamps = new boolean[BIGGEST_VAMP + 1];
        //vamps[BIGGEST_VAMP] = true;
        //vamps[126] = true;
        //long startTime = System.currentTimeMillis();
        //for(int i = 127; i < 1000000; i++) {
        //    if (isVampire(i)) {
        //        vamps[i] = true;
        //    }
        //}
        //long endTime = System.currentTimeMillis();

        //System.out.println("Done creating array, took " + (endTime - startTime) + " milliseconds");

        for(;;) {
            int num = input.nextInt();
            if(num == 0) break;

            int i = num;
            for(; !isVampire(i); i++);

            System.out.println(i);


        }
    }

    private static boolean isVampire(int number) {
        HashSet<String> perms = getPermutations(number);

        for (String s : perms) {
            for (int i = 0; i < s.length() - 1; i++) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                for (int j = 0; j <= i; j++) {
                    sb1.append(s.charAt(j));
                }
                for (int j = i+1; j < s.length(); j++) {
                    sb2.append(s.charAt(j));
                }

                String s1 = sb1.toString();
                String s2 = sb2.toString();
                if (s1.charAt(0) == '0' || s2.charAt(0) == '0')
                    continue;
                int result = Integer.parseInt(s1) * Integer.parseInt(s2);
                //System.out.println(s1 + " times " + s2 + " equals " + result);
                if (result == number) {
                    //System.out.println("Returning true");
                    return true;
                }
            }
        }

        return false;
    }

    private static HashSet<String> getPermutations(int value) {
        HashSet<String> perms = new HashSet<String>(720);
        String pattern = Integer.toString(value);
        permutate(pattern.toCharArray(), 0, perms);
        return perms;
    }

    private static void permutate(char[] cArr, int index, HashSet<String> list) {
        if (index == cArr.length) {
            String s = charArrToString(cArr);
            if(!list.contains(s))
                list.add(s);
            return;
        }

        for(int i = 0; i < cArr.length; i++) {
            char[] cArr2 = Arrays.copyOf(cArr, cArr.length);
            swap(cArr2, index, i);
            permutate(cArr2, index+1, list);
            swap(cArr2, index, i);
        }
    }

    private static void swap(char[] cArr, int x, int y) {
        char temp = cArr[x];
        cArr[x] = cArr[y];
        cArr[y] = temp;
    }

    private static String charArrToString(char[] cArr) {
        StringBuilder sb = new StringBuilder();
        for (char c : cArr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
