import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int[] a = new int[testCase];
        int[] b = new int[testCase];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase;i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a); //역으로
        Arrays.sort(b);
        int result = 0;
        for (int i = 0; i < testCase;i++) {
            result += (a[testCase - i - 1] * b[i]);
        }
        System.out.println(result);
    }
}
