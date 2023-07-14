import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer,Integer> arr = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            int num = Integer.parseInt(st.nextToken());

            if (arr.containsKey(num)) { //해당번호가 중복되는경우
                arr.put(num,arr.get(num) + 1); //value를 1추가
            } else { //중복되지 않는경우
                arr.put(num, 1); //value에 1넣음
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M;i++) {
            int mNumber = Integer.parseInt(st.nextToken());

            if (arr.containsKey(mNumber)) {
                sb.append(arr.get(mNumber)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
