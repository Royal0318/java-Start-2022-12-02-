import java.util.Scanner;

public class codeup1542 {
    public static void main(String[] args) {
        if (f() == 1) {
            System.out.println("prime");
        } else {
            System.out.println("composite");
        }
    }
    static int f () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        int temp = 0;
        int check = 0;

        while (start <= n) {
            if ((n / start) != 0 && (n % start) == 0) {
                temp += 1;
            }
            start += 1;
        }
        if (temp == 2) {
            check = 1;
        }
        return check;
    }
}
