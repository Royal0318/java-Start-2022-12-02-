import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int testCase = Integer.parseInt(br.readLine());

        int[] weight = new int[testCase];

        for (int i = 0; i < testCase;i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight);
        int loopNumber = 1;
        for (int i = (testCase - 1); i >= 0 ;i--) {
            int temp = (weight[i] * loopNumber);
            if (result < temp) result = temp;
            loopNumber += 1;
        }
        System.out.println(result);
    }
}
