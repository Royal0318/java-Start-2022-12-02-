import java.util.Scanner;

public class Question5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        String str = sc.next();

        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == 'A' || str.charAt(i) == 'B' || str.charAt(i) == 'C') {
                result += 3;
            } else if (str.charAt(i) == 'D' || str.charAt(i) == 'E' || str.charAt(i) == 'F') {
                result += 4;
            } else if (str.charAt(i) == 'G' || str.charAt(i) == 'H' || str.charAt(i) == 'I') {
                result += 5;
            } else if (str.charAt(i) == 'J' || str.charAt(i) == 'K' || str.charAt(i) == 'L') {
                result += 6;
            } else if (str.charAt(i) == 'M' || str.charAt(i) == 'N' || str.charAt(i) == 'O') {
                result += 7;
            } else if (str.charAt(i) == 'P' || str.charAt(i) == 'Q' || str.charAt(i) == 'R' || str.charAt(i) == 'S') {
                result += 8;
            } else if (str.charAt(i) == 'T' || str.charAt(i) == 'U' || str.charAt(i) == 'V') {
                result += 9;
            } else if (str.charAt(i) == 'W' || str.charAt(i) == 'X' || str.charAt(i) == 'Y' || str.charAt(i) == 'Z') {
                result += 10;
            }
        }
        System.out.println(result);
    }
}
