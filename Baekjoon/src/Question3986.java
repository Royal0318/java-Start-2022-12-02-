import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < testCase;i++) {
            String str = br.readLine();

            if (str.length()%2 == 0) {
               stack.push(str.charAt(0)); //0번은 푸쉬한다 왜냐하면 밑에 if문에서 0번과 j를 비교해야 하기 때문

                for (int j = 1; j < str.length();j++) {
                    if (stack.size() > 0 && stack.peek() == str.charAt(j)) {
                        //push하기전에 peek랑 비교하고 시작하는것이 중요
                        //size는 0이라면 무조건 푸쉬해야한다 peek와 비교해야 하기 때문에
                        if (stack.peek() == str.charAt(j)) { //가장위에 존재하는단어가 j와 같을경우
                            stack.pop(); //해당단어는 pop시킨다
                        }
                    } else {
                        stack.push(str.charAt(j));
                    }
                }
                if (stack.empty()) {
                    result += 1;
                }
                stack.clear();
            }
        }
        System.out.println(result);
    }
}
