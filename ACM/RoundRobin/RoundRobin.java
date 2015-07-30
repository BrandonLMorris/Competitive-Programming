/*ACM -- Round Robin
 *Created by Brandon Morris 10/19/14
 */
import java.util.*;

public class RoundRobin {
    public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	int numPlayers = input.nextInt();
	while(numPlayers != 0){
	    int turnsPerRound = input.nextInt();
	    int[] playersArray = new int[numPlayers];
	    int currentIndex = 0;

	    boolean hasMoreRounds = true;
	    while(hasMoreRounds){
		for(int i = currentIndex; i < turnsPerRound+currentIndex; i++){
		    if(playersArray[i%numPlayers] == -1){
			i--;
			continue;
		    } 
		    else {
			playersArray[i%numPlayers] += 1;
		    }
		}
		currentIndex = ((turnsPerRound+currentIndex)%numPlayers)-1;
	        playersArray[currentIndex] = -1;			//player is eliminated
		for(int j : playersArray){
		    System.out.print(j + " ");
		}
		System.out.println();

		int firstActivePlayer = 0;
		while(playersArray[firstActivePlayer] == -1){
		    firstActivePlayer++;
		}
		hasMoreRounds = false;
		for(int points : playersArray){
		    if (points == -1) continue;
		    if (points != playersArray[firstActivePlayer]){
			hasMoreRounds = true;
			break;
		    }
		}
	    }
	    int pointsPerPlayer = 0;
	    int numPlayersLeft = 0;
	    for(int x : playersArray){
		if(x == -1) continue;
		pointsPerPlayer = x;
		numPlayersLeft++;
	    }
	    System.out.println(pointsPerPlayer + " " + numPlayersLeft);

	    numPlayers = input.nextInt();
	}
    }
}
