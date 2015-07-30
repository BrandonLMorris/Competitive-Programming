/*ACM :: Round Robin
 *Created by Brandon Morris 10/20/14
 *Second attempt using Java LinkedList
 */
import java.util.*;

public class RoundRobin2{
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int numPlayers = input.nextInt();
	while(numPlayers != 0){
	    int turnsPerRound = input.nextInt();
	    int lastPlayer = 0;				//keeps up with turns across multiple rounds
	    int playerTurn = 0;

	    LinkedList players = new LinkedList();
	    for(int i = 0; i < numPlayers; i++){	//creates a linked list for each player in the game
		players.add(new Integer(0));
	    }

	    boolean gameOver = false;
	    while(!gameOver){
		for(int i = lastPlayer; i < turnsPerRound+lastPlayer; i++){
		    playerTurn = i;
		    while(playerTurn >= players.size()){
			playerTurn -= players.size();
		    }
		    Integer playerVal = (Integer)players.get(playerTurn);
		    playerVal++;
		    players.set(playerTurn, playerVal);		//increments the current players value
		}
		lastPlayer = playerTurn;
		players.remove(lastPlayer);					//last player in the round is eliminated
		gameOver = true;
		for(int i = 1; i < players.size(); i++){			//checks if game is over by comparing all points to player 1
		    if(players.get(0) != players.get(i)){
			gameOver = false;
			break;
		    }
		}
	    }

	    System.out.print(players.size() + " " + players.get(0));
	    System.out.println();

	    numPlayers = input.nextInt();
	}
    }
}
