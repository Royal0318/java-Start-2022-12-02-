import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        int myMoney = Integer.parseInt(st.nextToken());
        int result = 0;

        int[] arr = new int[testCase];
        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = (testCase - 1);i >= 0;i--) {
            if (arr[i] <= myMoney) {
                result += (myMoney / arr[i]); //몫
                myMoney -= (arr[i] * (myMoney/arr[i]));
            }
        }
        System.out.println(result);
    }
}
