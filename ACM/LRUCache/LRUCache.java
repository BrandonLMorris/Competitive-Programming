import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int simNum = 1;; simNum++) {
            int cacheSize = Integer.parseInt(input.next());
            if(cacheSize == 0) break;
            char[] sequence = input.next().toCharArray();
            char[] cache = new char[cacheSize];

            // for(char c : cache) {
            //     if(c != 0){
            //         System.out.print(c + " ");
            //     }
            //     else System.out.print("\\0 ");
            // }
            // System.out.println();

            System.out.println("Simulation " + simNum);

            for(int i = 0; i < sequence.length; i++) {
                char current = sequence[i];
                if(current == '!') {
                    printCache(cache);
                } else {
                    addToCache(current, cache);
                }
                // for(char c : cache) {
                //     if (c != 0){
                //         System.out.print(c + " ");
                //     }
                //     else
                //         System.out.print("\\0 ");
                // }
                // System.out.println();
            }
            //printCache(cache);
        }
    }

    private static void printCache(char[] cache) {
        for(char c : cache) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void addToCache(char charArg, char[] cacheArg) {
        //Possibilities:
        //Contains empty indexes and does not contain the argument
            //Add arg to first empty index
        //Contains empty indexes and does contain the argument

        //Is filled and does not contain the argument
        //Is filled and does contain the argument

        //IF CONTAINS ELEMENT, DOES MATTER IF HAS EMPTY INDEXES
        boolean containsEmpty = false;        
        boolean containsArg = false;
        int argIndex = 0;

        for(int i = 0; i < cacheArg.length; i++) {
            if(cacheArg[i] == 0){
                containsEmpty = true;
            }
            if(cacheArg[i] == charArg) {
                containsArg = true;
                argIndex = i;
            }
        }

        if(containsArg) {
            for(int i = argIndex; i < cacheArg.length-1; i++) {
                cacheArg[i] = cacheArg[i+1];
                if(cacheArg[i] == 0) {
                    cacheArg[i] = charArg;
                    return;
                } 
            }
            cacheArg[cacheArg.length-1] = charArg;
        } else if(containsEmpty) {
            for(int i = 0; i < cacheArg.length; i++) {
                char c = cacheArg[i];
                int cInt = (int) c;
                if(cInt == 0) {
                    cacheArg[i] = charArg;
                    break;
                }
            }
        } else { /*Does not contain the element and has no empty slots*/
            for(int i = 0; i < cacheArg.length-1; i++) {
                cacheArg[i] = cacheArg[i+1];
            }
            cacheArg[cacheArg.length-1] = charArg;
        }

        return;
    }
}