import java.util.Scanner;

public class Question1259b {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            } else {
                if (!f(n)) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
        }
    }
    static boolean f(int n) {
        boolean check = true;
        String str = "" + n + "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                check = false;
                break;
            }
        }

        return check;
    }
}
