import java.util.*;

public class Quine{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            String fullLine = input.nextLine();
            if(fullLine.equals("END")) break;
            //boolean isQuine = true;
            if(fullLine.charAt(0) != '\"') {
                System.out.println("not a quine");
                continue;
            } else {
                //System.out.println("Passes test 1");
            }

            //Shortest possible quine is five characters => "A" A
            if(fullLine.length() < 4 || fullLine.charAt(1) == '\"' || fullLine.charAt(1) == ' ') {
                System.out.println("not a quine");
                continue;
            }  else {
                //System.out.println("Passes test 2");
            }
            
            int secondQuote = fullLine.indexOf('\"', 1);
            
            if(secondQuote == -1) {
                System.out.println("not a quine");
                continue;
            } else {
                //System.out.println("Passes test 3");
            }
            
            if(fullLine.charAt(secondQuote - 1) == ' ') {
                System.out.println("not a quine");
                continue;
            } else {
                //System.out.println("Passes test 4");
            }

            if(fullLine.length() <= secondQuote + 2) {
                System.out.println("not a quine");
                continue;
            }

            if(fullLine.charAt(secondQuote + 1) != ' ') {
                System.out.println("not a quine");
                continue;
            }

            
            String phrase = fullLine.substring(1, secondQuote);

            if(fullLine.length() > secondQuote + 1) {
                String phrase2 = fullLine.substring(secondQuote + 2, fullLine.length());
                //System.out.println("Phrase1 " + phrase);
                //System.out.println("Phrase2 " + phrase2);
                if(!phrase2.equals(phrase)) {
                    System.out.println("not a quine");
                    continue;
                }
            } else {
                System.out.println("not a quine");
                continue;
            }


            System.out.println("Quine(" + phrase + ")");
        }
    }
}

//To be a quine, it must follow the pattern exactly:
    //1. A quotation mark
    //2. A nonempty sequence of letters and spaces
    //3. A quotation mark
    //4. A space
    //5. Phrase A, exactly as it appeard in (2)