/*HackerRank :: Algorithms :: Warmup :: ACM ICPC Team
 *Created by Brandon Morris 10/13/2014
 *Given number of teams with bit maps of specialties, determine max number of topics from any pair, and how many teams can have max number
 *Bitwise operater inclucive OR (|) will be helpful
 *??Read members as bitmaps and not integers??
 */
import java.util.*;

public class ACMICPC{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int numPeople = input.nextInt();
		int numTopics = input.nextInt();
		input.nextLine();
		ArrayList<Boolean[]> people = new ArrayList<Boolean[]>(numPeople);		//stores all people of boolean arrays of topics

		//take in all the arrays
		for(int i = 0; i < numPeople; i++){
			String person = input.nextLine();
			Boolean[] topics = new Boolean[numTopics];
			for(int j = 0; j < numTopics; j++){
				if(person.charAt(j)=='1'){
					topics[j] = true;
				} else  topics[j] = false;	
			}
			people.add(topics);
		}

		//Nested loop to compare each person and find max topics
		int maxTopics = 0;
		for(int i = 0; i < numPeople-1; i++){
			for(int j = i; j < numPeople; j++){
				int sharedTopics = 0;
				for(int k = 0; k < numTopics; k++){
					if(people.get(i)[k] || people.get(j)[k]){
						sharedTopics++;
					}	
				}
				if (sharedTopics > maxTopics) maxTopics = sharedTopics;
			}
		}

		//Now find all the teams that share maxTopics topics
		int totalMaxTopics = 0;
		for(int i = 0; i < numPeople-1; i++){
			for(int j = i; j < numPeople; j++){
				int sharedTopics = 0;
				for(int k = 0; k < numTopics; k++){
					if(people.get(i)[k] || people.get(j)[k]){
						sharedTopics++;
					}	
				}
				if (sharedTopics == maxTopics) totalMaxTopics++;
			}
		}
		
		//Print out results
		System.out.println(maxTopics);
		System.out.println(totalMaxTopics);
	}
}
