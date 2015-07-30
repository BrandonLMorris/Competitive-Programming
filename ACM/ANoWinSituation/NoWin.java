import java.util.*;

public class NoWin{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(;;) {
            String deckStr = input.nextLine().trim();
            if(deckStr.equals("JOKER")) break;

            char[] deck = deckStr.toCharArray();

            boolean canWin = false;

            int possibleDraws = deck.length - 4;
            //System.out.println("possible draws: " + possibleDraws);
            
            

            for(int i = 0; i < possibleDraws; i++) {

                ArrayList<Character> playerHand = new ArrayList<Character>();
                ArrayList<Character> dealerHand = new ArrayList<Character>();
                playerHand.add(deck[0]);
                playerHand.add(deck[2]);
                dealerHand.add(deck[1]);
                dealerHand.add(deck[3]);

                //Draw i number of cards for player
                for(int j = 0; j < i; j++) {
                    playerHand.add(deck[j + 4]);
                }

                //if player busts
                if(calculateHand(playerHand) > 21) 
                    continue;
                
                //Start drawing for the dealer after the player. Keep drawing until has at least 17 points or runs out of cards
                int currentCard = i + 4;
                while(calculateHand(dealerHand) < 17 /*&& currentCard < deck.length*/) {
                    dealerHand.add(deck[currentCard]);
                    currentCard++;
                }

                //Print for debug
                //System.out.println(i + "\t" + calculateHand(playerHand) + "\t" + calculateHand(dealerHand));

                //Player wins if dealer busted, has higher points or they tied
                if(calculateHand(dealerHand) > 21) {
                    canWin = true;
                } else if(calculateHand(playerHand) > calculateHand(dealerHand)) {
                    canWin = true;
                } else if(calculateHand(playerHand) == calculateHand(dealerHand)) {
                    canWin = true;
                }
            }

            //Print out the result
            if(canWin) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    //Calculates the score for a given hand
    private static int calculateHand(ArrayList<Character> hand) {
        int score = 0;
        int numAces = 0;
        for(Character c : hand) {
            if(Character.isDigit(c)) {
                score += Character.getNumericValue(c);
            } else if(c.equals('A')) {
                score += 11;
                numAces++;
            } else {
                score += 10;
            }
        }

        while(score > 21 && numAces > 0) {
            score -= 10;
            numAces--;
        }

        return score;
    }
}