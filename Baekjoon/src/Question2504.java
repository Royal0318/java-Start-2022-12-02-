import java.util.Scanner;
import java.util.Stack;

public class Question2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int temp = 1;
        String str = sc.next();

        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == '(') { //반대괄호는 바로 0이지만 열림괄호는 push한다
                stack.push(str.charAt(i));
                temp *= 2;
            } else if (str.charAt(i) == '[') {
                stack.push(str.charAt(i));
                temp *= 3;
            } else if (str.charAt(i) == ']') {
                if (stack.empty() || stack.peek() !=  '[') {
                    sum = 0;
                    //만일 charAt(i)가 ]일때 스택이비어있거나 pop조건인 [가 아닌경우 올바르지 못한괄호이기때문에 종료
                    break;
                } else if (str.charAt(i- 1) == '[') { //만약 전에괄호가 열림괄호라면 pop된다
                    sum += temp; //pop되기때문에 temp에 담고있던 값을 sum에 할당
                }
                stack.pop();
                temp = (temp / 3);

                /*
                주의할점은 charAt(i)가 ]거나 )일때 if문에  str.charAt(i- 1) == '['가 먼저오면 안된다
                그 이유는 전에 과정해서 pop한상태에서 만약에 스택이 비어있다면 다음에 i가 돌았을때
                str.charAt(i- 1) == '['가 먼저 있을때 if와 elseif둘다 실행되버린다

                 */
            } else if (str.charAt(i) == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') { //만약 전에괄호가 열림괄호라면 pop된다
                    sum += temp;
                }
                stack.pop();
                temp = (temp / 2);
            } else {
                break;
            }
        }
        //만약에 스택이 남아있으면올바르지 못한 괄호
        if (!stack.empty()) {
            System.out.println(0);
        } else { //스택이 모두비어있으면 올바른괄호
            System.out.println(sum);
        }
        /*
        괄호가 열리는 부분은 스택을 쌓으며 i번째 char값을 보고 그전에 char 문자열이 어느것인지 판단하는것이 중요하다
        전에것이 열리는괄호였다면 pop하고 열리는괄호가 아니고 다른괄호면 올바른 문자열이 아니므로 break
        열리는괄호가 동일하다면 푸쉬를해야한다
         */
    }
}