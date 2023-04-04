import java.io.IOException;
import java.util.Scanner;

public class Question11720 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        String num = sc.next();
        int start = 0;
        long sum = 0;

        while (start < testCase) {
           sum += num.charAt(start) - '0';
           start += 1;
       }
        System.out.println(sum);
    }
}
