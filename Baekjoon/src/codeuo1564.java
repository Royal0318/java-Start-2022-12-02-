import java.util.Scanner;

public class codeuo1564 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
       long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(((n * m) / f(n,m)));
    }
    static long f (long n,long m) {
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        } else {
            return f(m,(n%m));
        }
    }
}
