import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0; //정답
        int count = 1; //1부터 count
        for (int i = 1; i < 1000;i++) { //총 범위가 1000까지 존재하기 때문에 1000으로 제한
            for (int j = 0; j < i;j++) { //예를들어 i가 10이면 10번 나오기때문에 2중포문을 이용하였다
                if (count >= A && count <= B) { //count가 A와같을때 i를 sum에 넣기시작하며 B에 도달시 탈출
                    sum += i;
                }
                count += 1;
            }
        }
        System.out.println(sum);
    }
}
