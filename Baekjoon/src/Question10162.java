import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int A = 0;
        int B = 0;
        int C = 0;

        if (testCase >= 300) { //분으로 주어진것을 초로 바꾼다
            A = (testCase / 300); //횟수카운트
            testCase -= (300 * A); //300초 * 횟수만큼 전체 초에서 차감
        }
        if (testCase >= 60) {
            B = (testCase / 60);
            testCase -= (60 * B);
        }
        if (testCase >= 10) {
            C = (testCase / 10);
            testCase -= (10 * C);
        }
        if (testCase == 0) {
            System.out.println("" + A + " " + B + " " + C + "");
        } else {
            System.out.println(-1);
        }
    }
}
