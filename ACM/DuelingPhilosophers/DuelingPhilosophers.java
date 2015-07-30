import java.util.*;

public class DuelingPhilosophers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numEssays = input.nextInt();
        int numRelations = input.nextInt();

        for(;;) {
            if(numEssays == 0) break;

            ArrayList<Essay> essays = new ArrayList<Essay>(numEssays);
            for(int i = 0; i < numEssays; i++) {
                essays.add(new Essay());
            }

            for(int i = 0; i < numRelations; i++) {
                int first = input.nextInt();
                int second = input.nextInt();
                essays.get(first-1).next = essays.get(second-1);
            }

            boolean isCycle = false;
            boolean oneSolution = false;
            for(Essay e : essays) {
                Essay current = e;
                boolean[] visits = new boolean[numEssays];
                visits[essays.indexOf(current)] = true;
                while(current.next != null) {
                    if(visits[essays.indexOf(current.next)]){
                        isCycle = true;
                        break;
                    }
                    current = current.next;
                    visits[essays.indexOf(current)] = true;
                }
                if(isCycle) break;
                boolean visitedEvery = true;
                for(boolean b : visits) {
                    if(!b) {
                        visitedEvery = false;
                    }
                }
                if(visitedEvery) {
                    oneSolution = true;
                    break;
                }
            }

            if(isCycle) System.out.println(0);
            else if(oneSolution) System.out.println(1);
            else System.out.println(2);



            numEssays = input.nextInt();
            numRelations = input.nextInt();
        }
    }
}

class Essay {
    Essay next;
    //ArrayList<Essay> prev;
        public Essay() {
        next = null;
        //prev = new ArrayList<Essay>();
    }
}

