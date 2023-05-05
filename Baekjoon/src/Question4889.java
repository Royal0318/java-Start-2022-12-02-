import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = 1;
        //출력에 입력번호가 순서대로 출력되도록함
        while (true) {
            int result = 0;
            Stack<Character> stack = new Stack<>();
            //한바퀴 돌 때 마다 스택이 초기화된다
            String str = br.readLine();

            if (str.charAt(0) == '-') { //시스템 종료조건 이부분이 다르면 NullPointer오류가 발생한다
                break;
            } else {
                for (int i = 0; i < str.length();i++) {
                    char a = str.charAt(i);
                    if (stack.empty()) {
                        stack.push(a); //스택이 비어있으면 채움
                    } else {
                        if (stack.peek() == '{' && a == '}') {
                            stack.pop();
                            //처음입력과정에서 스택이 {}이 나타나면 pop시키고 이후에 판단함
                        } else {
                            stack.push(a); //그외에것은 push한다
                        }
                    }
                }
                int size = stack.size();
                while ((size - 1) > 0) { //입력되는건 짝수이기때문에 2개씩 줄며 판단시작
                    if (stack.empty()) {
                        System.out.println(""+testCaseNumber+". "+stack.size()+"");//만약에 스택이 비어있다면 0을출력
                        break;
                    } else {
                        if (stack.peek() == '{' && stack.get(stack.size()-2) == '{' || stack.peek() == '}' && stack.get(stack.size()-2) == '}') {
                            //비어있지 않은데 모양이 같은것이 나타난다면 하나만 돌리면 pop조건에 해당하므로 result를 1개올림
                            result += 1;
                        } else { //그 외에는 }{인데 이것은 2개를 모두 돌려야하므로 2개올림
                            result += 2;
                        }
                        stack.pop();
                        stack.pop();
                        size -= 2;
                        //한바퀴돌때마다 2개씩 pop함
                    }
                }
                System.out.println(""+testCaseNumber+". "+result+"");
            }
            testCaseNumber += 1;
        }
    }
}
