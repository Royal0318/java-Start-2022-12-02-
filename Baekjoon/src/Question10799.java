import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question10799 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int result = 0;

        for (int i = 0 ; i < str.length();i++) {
            char temp = str.charAt(i);

            if (temp == '(') {
                stack.push(temp);
            }
            else { // )인경우
                if (!stack.empty()) {
                    stack.pop();

                    if (str.charAt(i - 1) == ')') { //전에 문자가 )라면 레이저 X
                        result += 1;
                    }
                    else { //레이저이므로 막대기가나뉨
                        result += stack.size();
                    }
                }
            }
        }
        System.out.println(result);
    }
}
