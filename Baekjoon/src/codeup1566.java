import java.util.Scanner;

public class codeup1566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(f(n, m));
    }
    static long f (long n,long m) {
       if (m == 0) {
           return 1;
       } else {
           return n * f(n,m-1);
       }
    }
}
