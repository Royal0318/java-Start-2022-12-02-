import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Question10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader 선언
        int test = Integer.parseInt(br.readLine());
        //test변수를 통해 입력값을 받는다
        int sum = 1;
        //팩토리얼을 구현하기 위해 전체 팩토리얼 결과값을 담는 변수

        for (int i = test; i >= 1;i--) {
            //for문을 통해 입력한 팩토리얼 시작값에서 역으로 가며 곱한값을 sum변수에 저장
            sum *= i;
        }
        PrintWriter pr = new PrintWriter(System.out);
        //PrintWriter 선언을 통해 결과값 출력
        pr.println(sum);
        pr.flush();
        pr.close();
    }
}
