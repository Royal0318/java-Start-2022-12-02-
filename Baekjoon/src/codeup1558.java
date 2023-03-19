import java.util.Scanner;

public class codeup1558 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(f(n));
    }
    static long f (long n) {
        long result = 0;

        while (n != 0) {
            result = (result * 10 + n%10);
            n = (n/10);
        }
        return result;
    }
}
