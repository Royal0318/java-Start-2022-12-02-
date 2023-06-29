import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question2257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Integer> stack = new Stack<>(); //스택선언
        int numberSave = 0; //임시 저장
        int result = 0; //정답저장
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == 'H') {
                stack.push(1);
            } else if (str.charAt(i) == 'O') {
                stack.push(16);
            } else if (str.charAt(i) == 'C') {
                stack.push(12);
            } else if (str.charAt(i) == '(') {
                stack.push(0); //괄호는 0으로 취급
            } else if (str.charAt(i) == ')') { //닫는괄호가 나올시
                while (true) { //반복문을돌면서
                    if (stack.peek() == 0) { //여는괄호나올시 탈출
                        stack.pop(); //여는괄호 pop하면서
                        stack.push(numberSave); //괄호안에 번호들을 다시 push한다
                        numberSave = 0; //변수  리셋
                        break;
                    } else { //숫자들나올시
                        numberSave += stack.pop(); //가장위에존재하는것을 pop하면서 숫자와곱함
                    }
                }
            } else { //숫자나올시
                int temp = (stack.pop() * (str.charAt(i)-48)); //숫자같아보이지만 입력을 문자열로 해줬기때문에 조심해야함
                stack.push(temp);
            }
        }
        while (!stack.empty()) { //스택이 빌때까지 pop
            result += stack.pop();
        }
        System.out.println(result);
    }
}
