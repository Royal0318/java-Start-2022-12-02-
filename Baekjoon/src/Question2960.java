import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check= new boolean[N + 1]; //N까지 배열생성

        int count = 0;
        for (int i = 2; i <= N;i++) {
            for (int j = i;j <= N;j+=i) {
                if (!check[j]) { //그값이 false면 아직 설정하지않은값
                    count += 1;
                    check[j] = true;
                }
                if (count == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
        /*
        힌트가 주어졌다 2, 4, 6, 8, 10, 3, 9, 5, 7 순서대로 지워진다. 7번째 지워진 수는 9이다.
        라고 주어진것을 본다면 시작지점은 2부터니까 2의배수만큼 배열에 넣는데 그값이 N을 넘으면안된다
        그렇기 때문에 2가 제일작은값이니까 P이며 N까지 모두 넣는데 불린의 초기값은 false기때문에
        배수값은 true를 부여하여 다음 P의 배수가 나올때 중복되지 않도록한다
        예를들어서 10 7이라고한다면
        처음에 i가 2로시작하여 2 4 6 8 10이먼저 true가되며
        다음에 i가 3이되어 3 9 가된다 6은 미리 ture가 되었기 때문에 넘어간다
        count가 이때 7이되어 이때의 j값을 출력하면된다
         */
    }
}
