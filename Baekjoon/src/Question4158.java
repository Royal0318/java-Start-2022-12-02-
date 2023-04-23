import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //tokenizer도 가능하지만 spit으로도 가능하다
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) { //0 0 이나올때까지 계속 테스트 입력한다는 뜻
                break;
            }
            long[] Narr = new long[N];
            long[] Marr2 = new long[M];
            int result = 0;

            for (int i = 0; i < N; i++) {
                Narr[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                Marr2[i] = Integer.parseInt(br.readLine());
            }
            int start = 0;
            int end = 0;

            while (start < N) {
                //Narr이 N - 1에 도달하면 전부 검사한것
                if (Narr[start] == Marr2[end]) {
                    start += 1;
                    end += 1;
                    result += 1;
                } else if (Narr[start] < Marr2[end]) {
                    //Marr2가 더크다는것은 순차적으로 나열되어있으므로 start를 늘려 값을 높인다
                    start += 1;
                } else {
                    end += 1;
                }
            }
            System.out.println(result);
        }
    }
}
