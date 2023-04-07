import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int result = 1;
        //자신을 포함하였기때문에 1부터 시작
        int max = 0; //조건이 2개를 만족해야한다 1.peek(보는곳) 부터 get(i)가 더 클것, 더 큰값보다 다음에 작은값인경우 보이지않으므로 카운트X,

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int stickHigh = Integer.parseInt(br.readLine());
            stack.push(stickHigh);
            max = stack.peek();
            //max에 peek 스택의 최고값을 저장
        }
        for (int i = (testCase-1); i >= 0; i--) {
            /*
            스택을 거꾸로 시작한다 예를들어 8 9 7 6 4 6인경우 맨오른쪽 6이 max가된다
            거기에서 if문을 테스트하기시작
            1.stack.peek = 6 < stack.get(6-1 = 5) -- > 4 이기때문에 카운트하지 않는다
            2.stack.peek = 6 < stack.get(4) -- > 6 이기때문에 같은값도 역시 카운트하지 않는다
            3.stack.peek = 6 < stack.get(3) -- > 7 이기때문에 max값은 7이되며 뒤에 max = 6 < stack.get(3) = 7 둘다만족하기때문에 count한다
            4.stack.peek = 7 < stack.get(2) -- > 9 이기때문에 max값은 9가되며 뒤에 max = 7 < stack.get(2) = 9 둘다만족하기때문에 count한다
            5.stack.peek = 9 < stack.get(1) -- > 8 이기때문에 조건에 만족하지 않으므로 count하지않음
            위처럼 완료했을때 2개 자신을 포함 총 3개가 된다
            주의할점은 스택맨위에서 보지만 9가 보이고 9뒤에 8은보이지 않으니 주의하자
             */
           if (stack.peek() < stack.get(i) && max < stack.get(i)) {
               max = stack.get(i);
               result += 1;
           }
        }
        System.out.println(result);
    }
}
