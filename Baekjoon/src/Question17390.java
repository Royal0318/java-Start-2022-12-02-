import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question17390 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int caseNumber = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] sum = new int[N + 1]; //기존의 arr.length의 길이 1을 더 추가하여 누적합 계산

        sum[0] = 0;
        for (int i = 1; i <= N;i++) { //누적 합 계산
            sum[i] = (sum[i - 1] + arr[i - 1]);
        }

        for (int i = 0 ; i < caseNumber;i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

             sb.append((sum[R] - sum[L - 1])).append("\n"); //각각입력에 대한 출력값을 비교하면 (R - L-1)을 도출할수있다
        }
        System.out.println(sb);
    }
}
