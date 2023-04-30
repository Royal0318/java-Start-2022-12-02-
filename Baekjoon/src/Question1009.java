import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < testCase;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = 1;

            for (int j = 0;j < b; j++) { //제곱을 계속해보면 각각의 값이 4사이클마다 뒤숫자가 반복
                temp = ((temp * a) % 10);
            }
            if (temp == 0) {
                temp = 10;
            }
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
        /*
        여기서 중요한것은 각각의 제곱값의 끝지점들이 4cycle마다 반복된다는것이다
        그래서 for문을 이용하였다 싸이클을 돌수있도록 for문을 사용하고
        temp값을 1로 기본설정 값 = temp * a값을 계산후 끝자리만 가져오도록 나누기 10을하였다
        만약 0이나오는경우 10이나오도록함
         */
    }
}
