import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(f(num));
        }
    }
    static int f (int num) throws IOException {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else if (num == 3) {
            return 4;
        } else {
            return f(num-3) + f(num-2) + f(num-1);
        }
    }
}
