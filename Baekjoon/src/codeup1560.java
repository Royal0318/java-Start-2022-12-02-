import java.util.Scanner;

public class codeup1560 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(f(n, m));
    }
    static long f (long n,long m) {
        if (n < m) {
            return (m - n);
        } else if (n > m) {
            return (n - m);
        } else {
            return 0;
        }
    }
}
