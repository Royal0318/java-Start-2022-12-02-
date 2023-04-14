import java.util.Scanner;

public class Question2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] reverseOne = new int[3];
        int[] reversetwo = new int[3];
        int check = 0;
        String str = sc.nextLine();

        reverseOne[0] = str.charAt(0) - '0';
        reverseOne[1] = str.charAt(1) - '0';
        reverseOne[2] = str.charAt(2) - '0';

        reversetwo[0] = str.charAt(4) - '0';
        reversetwo[1] = str.charAt(5) - '0';
        reversetwo[2] = str.charAt(6) - '0';

        for (int i = 2; i >= 0;i--) {
            if (reverseOne[i] < reversetwo[i]) {
                check = 1;
                break;
            } else if (reverseOne[i] > reversetwo[i]) {
                check = 2;
                break;
            }
        }
        if (check == 1) {
            System.out.print(reversetwo[2]);
            System.out.print(reversetwo[1]);
            System.out.print(reversetwo[0]);
        } else {
            System.out.print(reverseOne[2]);
            System.out.print(reverseOne[1]);
            System.out.print(reverseOne[0]);
        }
    }
}
