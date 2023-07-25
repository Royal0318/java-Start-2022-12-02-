import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Question12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> waitLine = new Stack<>(); //옆으로 빠지는곳

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = testCase - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }

        int count = 1;
        while (!stack.isEmpty()) {
            if (stack.peek() == count) { //가장위에있는 번호가 부르는번호와일치
                stack.pop();
                count += 1;
            }
            else if (!waitLine.isEmpty() && waitLine.peek() == count) {// 옆으로 빠진사람들이 비어있지않으면서 peek가 count와 동일할경우
                waitLine.pop();
                count += 1;
            }
            else { //다른경우 옆으로 빠지게함
                waitLine.push(stack.pop());
            }
        }
        while (!waitLine.isEmpty()) { //만약에 옆대기줄에 사람이있다면
            if (count == waitLine.peek()) { //가장위에있는사람이 count와 일치하면 pop
                waitLine.pop();
                count += 1;
            }
            else { //그렇지않으면 답이맞지않으므로 sad출력
                System.out.println("Sad");
                return;
            }
        } //만약에 모두 비어있다면 nice
        System.out.println("Nice");
    }
}
