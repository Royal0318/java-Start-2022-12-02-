import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int result = 0;

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (!stack.empty()) { //스택이 남아있는경우
                if (stack.peek() == '(' && str.charAt(i) == ')') {
                    //최상단에 위치한 문자열이 (인경우 다음에 오는것이 )라면 최상단을 pop한다
                    stack.pop();
                } else if (stack.peek() == '(' && str.charAt(i) == '(') {
                    //최상단 다음에 오는것이 같은 문자열이라면 푸쉬한다
                    stack.push(str.charAt(i));
                }
            } else { //스택이 비어있는경우
                if (str.charAt(i) == ')') {
                    //스택이 비어있을때 )가오면 올바른 괄호를 만들 수 없다 그러므로 push하지 않으며 result만 카운트한다
                    result += 1;
                } else {
                    //(가 올때는 push한다
                    stack.push(str.charAt(i));
                }
            }
        }
        //result는 result와 남은스택의 size를더한것
        //중요한것은 미리 push하지않고 비교를 먼저 한 후 푸쉬하거나 하지않거나 판단하는것
        result = (result + stack.size());
        System.out.println(result);
    }
}
