import java.util.Scanner;

public class codeup1537 {
    public static void main(String[] args) {

        if (f() == 1) {
            System.out.println("hello");
        } else {
            System.out.println("world");
        }
    }
    static int f() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
