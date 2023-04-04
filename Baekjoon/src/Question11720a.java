import java.util.Scanner;

public class Question11720a {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = sc.next();
        System.out.println(plus(n,num));
    }
    static int plus (int n,String num) {
        if (n == 0) {
            return sum;
        } else {
            sum += num.charAt(n-1) - '0';
            return plus(n-1, num);
        }
    }
}
