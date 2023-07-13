import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M;i++) {
            int start = 0;
            int end = (arr.length - 1);
            boolean check = false;

            int num = Integer.parseInt(st.nextToken());

            while (start <= end) {
                int middle = ((start + end)/2);

                if (arr[middle] == num) {
                    sb.append(1).append(" ");
                    check = true;
                    break;
                } else if (arr[middle] < num) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            if (!check) {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
