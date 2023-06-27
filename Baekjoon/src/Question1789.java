import java.io.IOException;
import java.util.Scanner;

public class Question1789 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();

        long count = 0;
        long sum = 0;
        while (true) {
            sum += count;
            if (sum > S) break;
            count += 1;
        }
        System.out.println(count-1);
    }
}
