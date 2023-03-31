import java.util.Scanner;

public class codeup1620 {
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }

    static void f(int n) {
        String str2 = "" + n + "";

        for (int i = 0; i <= str2.length(); i++) {
            String str = "" + n + "";
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
                str2 = "" + sum + "";
            }
            n = sum;
            if (n < 10) {
                break;
            } else {
                sum = 0;
            }
        }
        System.out.println(n);
    }
}
