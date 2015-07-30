import java.util.*;

public class Runes {
	public static void main (String[] args){
		Scanner scannerIn = new Scanner(System.in);
		String copy = scannerIn.nextLine();
		long num1, num2, num3;
		boolean flag = false;
		
			
			long firstNum, secondNum;
			if (copy.contains("*")) {
				for (int i = 0; i < 10; i++) {
					if(copy.contains(Integer.toString(i))) continue;
					String input = copy.replace('?', Long.toString(i).charAt(0));
					Scanner s = new Scanner(input);
					String s1, s2, s3;
					s1 = input.substring(0, input.indexOf("*"));
					if (s1.length() == 1 || s1.charAt(0) != '0') {
						num1 = Long.parseLong(s1);
					} else { continue; }
					s2 = input.substring(input.indexOf("*") + 1, input.indexOf("="));
					if (s2.length() == 1 || s2.charAt(0) != '0') {
						num2 = Long.parseLong(s2);
					} else { continue; }
					s3 = input.substring(input.indexOf("=") + 1);
					if (s3.length() == 1 || s3.charAt(0) != '0') {
						//System.out.println("Hey, I'm getting run");
						num3 = Long.parseLong(s3);
					} else { continue; }

					if(s3.charAt(0) == '-' && num3 == 0) continue;
					
					if(num1 * num2 == num3) {
						flag = true;
						System.out.println(i);
						break;
					}
				}
			
			} else if (copy.contains("+")) {
				for (int i = 0; i < 10; i++) {
					if(copy.contains(Integer.toString(i))) continue;
					String input = copy.replace('?', Integer.toString(i).charAt(0));
					Scanner s = new Scanner(input);
					String s1, s2, s3;
					s1 = input.substring(0, input.indexOf("+"));
					if (s1.length() == 1 || s1.charAt(0) != '0') {
						num1 = Long.parseLong(s1);
					} else { continue; }
					s2 = input.substring(input.indexOf("+") + 1, input.indexOf("="));
					if (s2.length() == 1 || s2.charAt(0) != '0') {
						num2 = Long.parseLong(s2);
					} else { continue; }
					s3 = input.substring(input.indexOf("=") + 1);
					if (s3.length() == 1 || s3.charAt(0) != '0') {
						num3 = Long.parseLong(s3);
					} else { continue; }
					
					if(num1 + num2 == num3) {
						flag = true;
						System.out.println(i);
						break;
					}
				}
		
			} else {
				for (int i = 0; i < 10; i++) {
					if(copy.contains(Integer.toString(i))) continue;
					String input = copy.replace('?', Integer.toString(i).charAt(0));
					Scanner s = new Scanner(input);
					String s1, s2, s3;
					s1 = input.substring(0, input.indexOf("-", 1));
					if (s1.length() == 1 || s1.charAt(0) != '0') {
						num1 = Long.parseLong(s1);
					} else { continue; }
					s2 = input.substring(s1.length() + 1, input.indexOf("="));
					if (s2.length() == 1 || s2.charAt(0) != '0') {
						num2 = Long.parseLong(s2);
					} else { continue; }
					s3 = input.substring(input.indexOf("=") + 1);
					if (s3.length() == 1 || s3.charAt(0) != '0') {
						num3 = Long.parseLong(s3);
					} else { continue; }
					if(num1 - num2 == num3) {
						flag = true;
						System.out.println(i);
						break;
					}
				}
			}
			if (!flag) {
				int k = -1;
				System.out.println(k);
			}
		
				
	}
}
