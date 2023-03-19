import java.util.Scanner;

public class codeup1555 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println(f());
    }
    static long f () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        long sum = 0;
        while (start <= n) {
            sum += start;
            start += 1;
        }
        return sum;
    }
}
