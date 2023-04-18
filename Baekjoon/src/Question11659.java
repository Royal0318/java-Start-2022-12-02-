import java.io.IOException;
import java.util.Scanner;

public class Question11659 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int arrNum = sc.nextInt();
        int input =  sc.nextInt();

        long[] arr = new long[arrNum + 1];

        for (int i = 1; i <= arrNum;i++) {
            arr[i] = (arr[i - 1] + sc.nextInt());
        }
        //구간합의 중요한것은 배열을 미리 넣고 계산하는것이 아닌 미리 넣기전에 더해서 넣는것이다

        for (int i = 0 ; i < input;i++) {
            int one = sc.nextInt();
            int two = sc.nextInt();

            System.out.println((arr[two] - arr[one-1]));
        }
    }
}
