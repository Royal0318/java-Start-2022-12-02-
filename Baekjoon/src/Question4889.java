import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Question4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = 1;
        while (true) {
            int result = 0;
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            if (Objects.equals(str, "-")) {
                break;
            } else {
                for (int i = 0; i < str.length();i++) {
                    char a = str.charAt(i);
                    if (stack.empty()) {
                        stack.push(a);
                    } else {
                        if (stack.peek() == '{' && a == '}') {
                            stack.pop();
                        } else {
                            stack.push(a);
                        }
                    }
                }
                int size = stack.size();
                while ((size - 1) > 0) {
                    if (stack.empty()) {
                        System.out.println(""+testCaseNumber+". "+stack.size()+"");
                        break;
                    } else {
                        if (stack.peek() == '{' && stack.get(stack.size()-2) == '{' || stack.peek() == '}' && stack.get(stack.size()-2) == '}') {
                            result += 1;
                        } else {
                            result += 2;
                        }
                        stack.pop();
                        stack.pop();
                        size -= 2;
                    }
                }
                System.out.println(""+testCaseNumber+". "+result+"");
            }
            testCaseNumber += 1;
        }
    }
}
