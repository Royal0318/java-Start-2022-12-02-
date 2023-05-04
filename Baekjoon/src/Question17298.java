import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Question17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());
        int[] find = new int[testCase + 1];
        int[] result = new int[testCase + 1];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i< testCase;i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = testCase - 1; i >= 0;i--) { //3부터 0까지 총 4번실행
            while (!stack.empty() && stack.peek() <= find[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(find[i]);
        }
        for (int i = 0 ; i < testCase;i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
