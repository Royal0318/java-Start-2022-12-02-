import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10872a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader 선언
        int num = Integer.parseInt(br.readLine());

        int sum = test(num);
        //재귀호출을 받기위한 변수값이며 num에 입력받은값을 test메소드로 보낸다
        System.out.println(""+sum+"");

    }
    static int test(int num) {
        //test메소드에서 받으면 if문을 통해 조건부합 여부를 확인한다 1이 크거나 같을때까지 1을 계속리턴하며 그 예외로 1보다 큰경우 팩토리얼 함수 n * (met * (n-1));을 사용하여 최종출력
        if (num <= 1) {
            return 1;
        }
        return num * (test(num-1));
    }
}
