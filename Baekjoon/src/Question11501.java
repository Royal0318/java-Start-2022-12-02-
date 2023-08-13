import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < testCase; i++) {
            int inputNumber = Integer.parseInt(br.readLine());

            int[] arr = new int[inputNumber];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < inputNumber; j++) { //입력
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            long temp = 0;

            for (int j = 0 ; j < inputNumber;j++) {
                if (arr[inputNumber - j - 1] > temp) {
                    temp = arr[inputNumber - j - 1];
                }
                else {
                    result += (temp - arr[inputNumber - j - 1]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
