import java.util.*;

public class PartyGames {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String answer = "";                        //empty string that the answer will be added to

        int n = in.nextInt();                      //read in number of names in list TODO: qualify that n != 0
        while(n != 0) {
            in.nextLine();
            String[] namesArray = new String[n];
            for (int i = 0; i < n; i++) {
                namesArray[i] = in.nextLine().trim();
            }

            //Task #1: Sort the list
            //Using bubble sort
            int counter = 0;
            do {
                counter = 0;
                for (int i = 0; i < namesArray.length - 1; i++) {
                    if (namesArray[i].compareTo(namesArray[i + 1]) > 0) {
                        String temp = namesArray[i + 1];
                        namesArray[i + 1] = namesArray[i];
                        namesArray[i] = temp;
                        counter++;
                    }
                }
            } while (counter != 0);


            //Task #2: Find the smallest string that divides the list
            for(int i = 0; i < namesArray[(n/2)-1].length(); i++){
                //Three possible scenerios:
                //1 same-index chars of middle names are alike
                    //add char to answer string, continue
                //2 same-index chars of middle names are different and adjacent
                    //add alphabetically first char to answer string, break
                //3 smae-index chars of middle names are different and not adjacent
                    //add letter after alphabetically first char to string, break
                if(namesArray[(n/2)-1].charAt(i) == namesArray[(n/2)].charAt(i)){
                    answer += namesArray[(n/2)-1].charAt(i);
                    continue;
                }

                else if((namesArray[(n/2)-1].charAt(i) != namesArray[(n/2)-1].charAt(i) &&
                        namesArray[n/2].charAt(i)+1 == namesArray[(n/2)-1].charAt(i))||(i == namesArray[(n/2)-1].length()-1 && namesArray[n/2].charAt(i) == 'Z')){
                    answer += namesArray[(n/2)-1].charAt(i);
                    break;
                }

                else {
                    answer += (char)(namesArray[(n/2)-1].charAt(i) + 1);
                    break;
                }
            }



            System.out.println(answer);
            answer = new String("");
            n = in.nextInt();
        }
    }
}


/*From a list of names, find shortest possible integer that will divide the list evenly
* i.e.
* 4
* FRED
* SAM
* JOE
* MARGRET
* [output]: K
*
* Algorithm:
* 1. Sort the list
* 2. Compare the first character of two middle strings (n/2 - 1 and n/2)
*   2.1 If not equal
*       2.1.1 If not adjacent
*           Use character directly after n/2 - 1
*       2.1.2 If adjacent
*           Compare subsequent characters
*           2.1.2.1 Non-equal characters found
*               Repeat 2.1
*           2.1.2.2 End of string (of n/2 - 1)
*               Return shorter string (n/2 - 1)
* */