import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();

            String[] cut = str.split(" ");
            //단어를 공백을 기준으로 자른다
            for (String s : cut) {
                stack.push(s);
                //자른 단어덩어를 스택에 담는다
            }
            System.out.print("Case #"+(i+1)+": ");
            for (int j = 0 ; j < cut.length;j++) {
                System.out.print(stack.pop());
                //pop하면서 상단부터 출력한다
                System.out.print(" ");
            }
            System.out.println();
            stack.clear();
            //한바퀴돌때마다 스택을 전체 초기화한다
        }
    }
}
