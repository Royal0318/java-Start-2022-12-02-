import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,Integer> arr = new HashMap<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < N;i++) {
            arr.put(br.readLine(), i);
        }
        for (int i = 0; i < M;i++) {
            String str = br.readLine();
            if (arr.containsKey(str)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
