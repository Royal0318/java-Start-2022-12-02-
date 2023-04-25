import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int result = 0;

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] Narr = new int[N];
            int[] Marr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Narr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Narr);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Marr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(Marr);
            /*
            배열값을 입력받은 다음 Arraysort를 사용하여 탐색 시간을 단축한다
            작은것부터 배치되기때문에 sort를 하지 않는다면 전체적으로 탐색을 돌아야하기 때문에
            sort를 사용하지 않은것보다 시간이 더 오래걸려 시간초과가 발생한다
            그래서 서로 같거나 Marr이 더큰경우에는 카운트하지않으므로 break를 사용한다
             */
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (Narr[j] > Marr[k]) {
                       result += 1;
                    } else {
                        break;
                    }
                }
            }
           sb.append(result).append("\n");
        }
        System.out.println(sb);
        //append를 사용하여 한번에출력하도록함
    }
}
