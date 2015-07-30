/**
 * Utopian Tree
 * Created by bmorris on 9/20/14.
 */
import java.util.*;

public class UtopianTree {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int t = Integer.parseInt(input.nextLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(input.nextLine());
            int height = 1;
            for(int j = 0; j < n; j++){
                if(j%2 == 0){
                    height = height*2;
                    //System.out.println(j + ":" + height);
                }
                else{
                    height++;
                    //System.out.println(j + ":" + height);
                }
            }
            System.out.println(height);
        }
    }
}
