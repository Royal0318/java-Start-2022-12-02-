import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Question1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
      Arrays.sort(arr);

        int temp = 0;
        int result = 0;

        for (int i = 0 ; i < N;i++) {
            if (arr[i] > temp) {
                temp = arr[i] + L - 1;
                result += 1;
            }
        }
        System.out.println(result);
    }
}
