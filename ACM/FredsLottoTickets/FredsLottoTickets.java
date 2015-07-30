//ACM 2008 Freds Lotto Tickets
//Fred buys n number of lotto tickets containing n*6 numbers. See if he has bought
//each number betweet 1 and 49 inclusive
//created by Brandon Morris 10/6/2014

import java.util.*;

public class FredsLottoTickets {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		while(n != 0){
			int[] ticketNumbers = new int [49]; //int array containing indexes 0 to 48
			for(int i = 0; i < n*6; i++){
				ticketNumbers[input.nextInt()-1]++;
			}
			boolean coveredBases = true;
			for(int i : ticketNumbers){
				if (i == 0) coveredBases = false;
			}
			System.out.println(coveredBases?"Yes":"No");

			n = input.nextInt();
		}
	}
}
