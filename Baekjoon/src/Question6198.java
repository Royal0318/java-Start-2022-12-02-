import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long result = 0;

        for (int i = 0; i < testCase;i++) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
            result += stack.size() - 1;
        }
        System.out.println(result);
    }
}
/*
설명 : result를 long으로 해야하는이유는 테스트케이스가 80000까지 가능하다 그렇다는것은
80000부터 시작하여 1까지 모두 입력한다면 빌딩수 합은 int범위를 넘어서기 때문에 long으로 해야하는것이다
시뮬레이션 :
i = 1
10 <= 3은 성립하지 않으므로 스택에 10과 3이올라가고 정답은 1
i = 2
peek는 3이므로 3 <= 7이 성립하여 3이 pop되고 7이 올라가서 스택에 10 7 정답은 2
i = 3
peek는 7이므로 7 <= 4은 성립되지 않으며 4가 스택에올라가서 10/7/4가됨 정답은 4
i = 4
peek는4가되며 4 <= 12 가 성립되어 pop이되는데 스택에쌓인값들이 모두 12보다 작으므로 모두 pop되고
12가 새로올라가서 스택에 12만남고 정답은 4
i = 5
peek는 5가되며 12 <= 2 성립되지 않으며 스택에 12/2가남고 정답은 5가됨
 */
