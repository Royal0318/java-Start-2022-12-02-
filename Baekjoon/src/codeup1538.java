import java.util.Scanner;

public class codeup1538 {
    public static void main(String[] args) {
        if (f() > 0) {
            System.out.println("positive");
        }
    }
    static int f() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("zero");
        } else if (n < 0) {
            System.out.println("negative");
        } else {
            return n;
        }
        return 0;
    }
}
//왜 위에 3개를 몰아서하면안됨?
