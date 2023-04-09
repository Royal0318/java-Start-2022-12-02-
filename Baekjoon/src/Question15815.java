import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question15815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        String str = br.readLine();

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '*' || str.charAt(j) == '-' || str.charAt(j) == '/' || str.charAt(j) == '+') {
                /*
                여기서 중요한점은 하나씩 pop하면서 그값을 변수에 따로 저장하고 연산자에따라 다시 push해주는것이다
                후위연산자의 대표적인 유형이다
                 */
                int two = stack.pop();
                int one = stack.pop();
                //two가먼저 앞으로 오는이유는 나누기를할때 큰수에서 작은수를 나눠야하기때문에
                //two가 먼저 앞으로 왔다 주의해야할점이다

                if (str.charAt(j) == '*') {
                    stack.push((one * two));
                } else if (str.charAt(j) == '-') {
                    stack.push((one - two));
                } else if (str.charAt(j) == '+') {
                    stack.push((one + two));
                } else if (str.charAt(j) == '/') {
                    stack.push((one / two));
                }
            } else if (str.charAt(j) - '0' <= 9) {
                //만약 str.chat(j)가 숫자라면 그값이 9보다작을경우 스택에 push한다
                stack.push(str.charAt(j) - '0');
            }
        }
        for (Integer integer : stack) {
            sum += integer;
        }
        //스택이 1개이상 남는경우에는 모든값을 sum에넣어서 출력한다
        System.out.println(sum);
    }
}
