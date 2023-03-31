import java.util.Scanner;

public class codeup1620a {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }
    static int f (int n) {
        int sum = 0;
        String str = ""+n+"";
        if (n < 10) {
            result = n;
            return 1;
        }
        for (int i = 0; i < str.length();i++) {
            sum += str.charAt(i) - '0';
        }
        n = sum;
        f(n);
        return result;
    }
}
