/**
 * Politics
 * Created by bmorris on 9/20/14.
 */
import java.util.*;

public class Politics {
    public static void main(String[] args){
        Hashtable<String, ArrayList<String>> candidates = new Hashtable();
	Scanner input = new Scanner(System.in);
	int nCandidates = input.nextInt();
	while(nCandidates != 0){
	int nSupporters = input.nextInt();
	input.nextLine();
	ArrayList<String> canNames = new ArrayList<String>(nCandidates);
	for(int i = 0; i < nCandidates; i++){
		String canName = input.next();
		canNames.add(i, canName);
		candidates.put(canName, new ArrayList<String>());
	}
//	candidates.put("writein", new ArrayList<String>());			//for supporters who do not support a given candidate

	for(int i = 0; i < nSupporters; i++){
		String supporter = input.next();
		String candidate = input.next();
		if(candidates.containsKey(candidate)){				//checks if candidate is current
			candidates.get(candidate).add(supporter);
		}
		else{
			candidates.put(candidate, new ArrayList<String>());
			candidates.get(candidate).add(supporter);
			canNames.add(candidate);
		}
	}
	for(String i : canNames){
		for(String j : candidates.get(i)){
		//	for(String k : j){
				System.out.println(j);
		//	}
		}	
	}
	//for(String j : candidates.get("writein")){
	//	System.out.println(j);
	//}
	nCandidates = input.nextInt();
    }}
}
