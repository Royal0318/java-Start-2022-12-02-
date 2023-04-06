import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Question10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> sta = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();

            if (Objects.equals(str, "top")) {
                //top이나 pop같은경우 해당 스택에 아무것도없을때 -1을 출력한다 그러므로 바로 실행하지않고
                //변수에 미리 스택size를 체크한다 아무것도 없을경우 0이 출력되기 때문 그것으로 if문을 비교
                int check = sta.size();

                if (check == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(sta.peek());
                }
            } else if (Objects.equals(str, "size")) {
                System.out.println(sta.size());
            } else if (Objects.equals(str, "empty")) {
                if (sta.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (Objects.equals(str, "pop")) {
                int check = sta.size();

                if (check == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(sta.pop());
                }
            } else { //push
                String[] sp = str.split(" ");
                //공백을 기준으로 분리하는 spit명령어를 사용한다
                int n = Integer.parseInt(sp[1]);
                //push 2인경우 배열0번이 push가되고 정수부분이 배열1번이 되기때문임
                sta.push(n);
            }
        }
    }
}
