import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase;i++) {
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length();j++) {
                if (str.charAt(j) == '<') {
                    //<인경우 왼쪽에 스택이 존재할시 오른쪽으로 이동
                    if (!left.empty()) {
                        right.push(left.pop());
                    }
                } else if (str.charAt(j) == '>') {
                    //>인경우 오른쪽 스택이 존재할시 왼쪽으로 이동
                    if (!right.empty()) {
                        left.push(right.pop());
                    }
                } else if (str.charAt(j) == '-') {
                    //-인경우 가장최근것을 지우는 pop
                    if (!left.empty()) {
                        left.pop();
                    }
                } else {
                    //그 외에 알파벳이나 숫자는 왼쪽에 push
                    left.push(str.charAt(j));
                }
            }
            while (!right.empty()) {
                left.push(right.pop());
            }
            //이 코드가 필요한이유는 오른쪽에 존재하는 잉여의 문자열까지 완벽한 스택으로 만들기위하여 왼쪽으로 보내야하는 절차가 필요하다
            StringBuilder sb = new StringBuilder();
            for (Character character : left) {
                sb.append(character);
            }
            System.out.println(sb);
        }
        /*
        주의할점 : 입력되는 문자열이 100만개까지 존재하기 때문에 하나하나씩 출력하는 print는 시간초과가 발생한다
        그러므로 Stringbuilder를 이용하여 문자열을 한번에 저장후 한꺼번에 출력하는 방식을 사용해야 시간초과를
        방지할수있다
         */
    }
}
