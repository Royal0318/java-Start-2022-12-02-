import java.util.Scanner;

public class codeup1546 {
    public static void main(String[] args) {

        if (f() > 0) {
            System.out.println("plus");
        }
    }
    static int f () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("zero");
        } else if (n < 0) {
            System.out.println("minus");
        }
        return n;
    }
}
