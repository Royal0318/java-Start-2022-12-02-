import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                boolean check = false;
                int num = Integer.parseInt(st.nextToken());

                int start = 0;
                int end = (arr.length - 1);

                while (start <= end) {
                    int middle = ((start + end) / 2);

                    if (arr[middle] == num) {
                        sb.append(1).append("\n");
                        check = true;
                        break;
                    } else if (arr[middle] < num) {
                        start = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                }
                if (!check) {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
