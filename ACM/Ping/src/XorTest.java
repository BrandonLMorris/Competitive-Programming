import java.util.*;

public class XorTest {
    public static void main(String[] args) {
        char one = '1';
        char zero = '0';

        int answer = (int)one ^ (int)zero;

        char cAnswer = (char)(answer + (int)'0');

        System.out.println(cAnswer);
    }
}
