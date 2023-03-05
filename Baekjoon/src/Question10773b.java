import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Question10773b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        //stack선언
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < n;i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                //입력한 값이 0일경우 st.pop을 통해 가장위에있는스택을 뺌
                st.pop();
            } else {
                //입력한값이 0이 아닌경우 number값을 push
                st.push(number);
            }
        }
        for (int s : st) {
            System.out.println(""+s+"");
            sum += s;
        }
        System.out.println(""+sum+"");
    }
}
