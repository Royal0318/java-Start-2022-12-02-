import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0; //정답
        boolean check = false;
        if (N%5 == 0) { //만약에 N의수가 5로 바로나누어지면 몫을 출력하고 종료
            System.out.println(N/5);
        }
        else {
            while (N > 0) { //2씩 줄이면서 다시 5로나눠 떨어지면 종료 아니면 정답1개씩추가
                N -= 2;
                result += 1;

                if (N%5 == 0) {
                    check = true;
                    break;
                }
            }
            if (check) System.out.println(result + (N/5));
            //result에 5로나눈 몫추가
            else System.out.println(-1);
        }
    }
}
