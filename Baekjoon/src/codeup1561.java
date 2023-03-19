import java.util.Scanner;

public class codeup1561 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(f(n,m));
    }
    static int f(int n,int m) {
        if (n < m) {
            return m;
        } else if (n > m) {
            return n;
        } else {
            return n;
        }
    }
}
