/*ACM Balloons
 *Created by Brandon Morris 10/12/14
 */
import java.util.*;

public class Balloons{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int numTeams = input.nextInt();
		while(numTeams != 0){

            int aRoom = input.nextInt();
            int bRoom = input.nextInt();

            ArrayList<Team> teams = new ArrayList<Team>();
            for(int i = 0; i < numTeams; i++) {
                teams.add(new Team(input.nextInt(), input.nextInt(), input.nextInt()));
            }

            Collections.sort(teams);

            int remainder = 0;
            int distance = 0;

            for(Team t : teams) {
                if(t.aDist < t.bDist) {
                    if(aRoom > 0) {
                        if(t.balloonsNeeded > aRoom) {
                            distance += aRoom * t.aDist;
                            t.balloonsNeeded -= aRoom;
                            aRoom = 0;
                            distance += t.balloonsNeeded * t.bDist;
                            bRoom -= t.balloonsNeeded;
                        } else {
                            distance += t.balloonsNeeded * t.aDist;
                            aRoom -= t.balloonsNeeded;
                        }
                    } else {
                        distance += t.balloonsNeeded * t.bDist;
                        bRoom -= t.balloonsNeeded;
                    }
                } else if(t.bDist < t.aDist) {
                    if(bRoom > 0) {
                        if(t.balloonsNeeded > bRoom) {
                            distance += bRoom * t.bDist;
                            t.balloonsNeeded -= bRoom;
                            bRoom = 0;
                            distance += t.balloonsNeeded * t.aDist;
                            aRoom -= t.balloonsNeeded;
                        } else {
                            distance += t.balloonsNeeded * t.bDist;
                            bRoom -= t.balloonsNeeded;
                        }
                    } else {
                        distance += t.balloonsNeeded * t.aDist;
                        aRoom -= t.balloonsNeeded;
                    }
                }
                else if(t.aDist == t.bDist) {
                    if(aRoom > bRoom) {
                        distance += t.balloonsNeeded * t.aDist;
                        aRoom -= t.balloonsNeeded;
                    } else {
                        distance += t.balloonsNeeded * t.bDist;
                        bRoom -= t.balloonsNeeded;
                    }
                }
            }

            System.out.println(distance);

            numTeams = input.nextInt();
        }
	}

    static class Team implements Comparable<Team> {
        int balloonsNeeded;
        int aDist;
        int bDist;

        public Team(int x, int y, int z) {
            this.balloonsNeeded = x;
            this.aDist = y;
            this.bDist = z;
        }

        public int compareTo(Team other) {
            if(Math.abs(this.aDist - this.bDist) > Math.abs(other.aDist - other.bDist)) {
                return 1;
            } else if(Math.abs(this.aDist - this.bDist) > Math.abs(other.aDist - other.bDist)) {
                return -1;
            } else return 0;
        }
    }

}
