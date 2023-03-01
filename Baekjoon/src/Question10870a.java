import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10870a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(""+test(num)+"");
    }
    static int test (int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return test(num-1) + test(num-2);
        //1~10을 모두 더한값
    }
}
