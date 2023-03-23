import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3040b {
    static int[] arr = new int[9];
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        f(0, 1);
    }

    static void f(int one, int two) {
        if (two == 8 && one == 7) {
            arr[8] = 0;
            arr[7] = 0;
            return;
        } else {
            if ((sum - (arr[one] + arr[two])) == 100) {
                arr[one] = 0;
                arr[two] = 0;
                for (int i = 0; i < 9; i++) {
                    if (arr[i] != 0) {
                        System.out.println(arr[i]);
                    }
                }
                return;
            } else {
                if (two == 8) {
                    one += 1;
                    two = 0;
                }
            }
        }
        f(one, (two + 1));
    }
}
