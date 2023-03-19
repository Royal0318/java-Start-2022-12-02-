import java.util.Scanner;

public class codeup1557 {
    public static void main(String[] args) {
        System.out.println(f());
    }
    static int f () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

       for (int i = 1; i <= n;i++) {
           if ((n%i) == 0) {
               count += 1;
           }
       }
       return count;
    }
}
