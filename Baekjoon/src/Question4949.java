import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Question4949 {
    static Stack<Character> sta = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();

            if (Objects.equals(str, ".")) {
                //온점만 단독으로 존재할시 시스템을 종료한다
                break;
            } else {
                System.out.println(output(str));
            }
        }
    }
    static String output (String str) {
        sta.clear();
        //한번 답을 출력할때마다 스택초기화
        for (int i = 0 ; i < str.length();i++) {
            char check = str.charAt(i);


            if (check == '(' || check == '[') {
                sta.push(check);
                //(나 [는 push를한다

            } else if (check == ')') {
                if (sta.empty() || sta.peek() != '(') {
                    return "no";
                } else {
                    sta.pop();
                }
                //만약에 )나 ]인데 스택이 비어있다면 조건성립x,최상단 스택이 (가아니라면 짝이맞지 않으므로 성립x
            } else if (check == ']') {
                if (sta.empty() || sta.peek() != '[') {
                    //위와 마찬가지이다
                    return "no";
                } else {
                    sta.pop();
                }
            }
        }
        if (sta.size() == 0) {
            //최종적으로 짝이맞는다는것은 sta.size가 0인것이다 (는 추가되고 )는상쇄되기 때문
            return "yes";
        } else {
            return "no";
        }
    }
}
