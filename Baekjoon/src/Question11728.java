import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question11728 {
    public static void main(String[] args) throws IOException {
        //BufferReader와 Tokenizer를 이용한것 확실히 스캐너보다 속도가 빠르다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long[] arr = new long[a + b];
        long[] arr2 = new long[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = a; i < arr.length;i++) {
            arr[i] = arr2[temp];
            temp += 1;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length;i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
