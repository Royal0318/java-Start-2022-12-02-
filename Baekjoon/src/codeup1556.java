import java.util.Scanner;

public class codeup1556 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(f(num));
    }
    static int f (int n) {
       if (n == 1) {
           return 1;
       } else {
           return n * (f(n - 1));
       }
    }
}
