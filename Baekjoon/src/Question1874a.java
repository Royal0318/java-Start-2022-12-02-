import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question1874a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        int first = Integer.parseInt(br.readLine());
        int max = first;
        for (int i = 1; i <= first; i++) {
            stack.push(i);
            sb.append("+").append("\n");
        } //처음만 따로등록
        stack.pop();
        sb.append("-").append("\n");

        boolean check = false;
        for (int i = 0; i < testCase - 1; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > max) { //push과정
                for (int j = (max + 1); j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                max = num;
                stack.pop();
                sb.append("-").append("\n");
            } else { //pop과정
                if (stack.peek() != num) {
                    check = true;
                    break;
                } else {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }
        if (check) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
