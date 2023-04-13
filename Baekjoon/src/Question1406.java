import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();//왼쪽
        Stack<Character> right = new Stack<>();//오른쪽

        String str = br.readLine();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        for (int i = 0; i < testCase; i++) {
            String temp = br.readLine();

            if (temp.charAt(0) == 'P') {
                left.push(temp.charAt(temp.length() - 1));
            } else if (temp.charAt(0) == 'L') { //왼쪽에서 오른쪽으로 이동
                if (!left.empty()) { //스택이 비어있지 않으면 푸쉬
                    right.push(left.pop());
                }
            } else if (temp.charAt(0) == 'B') {
                if (!left.empty()) {
                    left.pop();
                }
            } else if (temp.charAt(0) == 'D') {
                if (!right.empty()) {
                    left.push(right.pop());
                }
            }
        }
        while (!right.empty()) {
            left.push(right.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (Character s : left) {
            sb.append(s);
        }
        //append로 한꺼번에 붙치고 출력한다
        System.out.println(sb);
    }
}
