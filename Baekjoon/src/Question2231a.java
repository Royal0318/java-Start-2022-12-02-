import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2231a {
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;
        f(n, result);
    }

    static void f(int n, long result) {
        sum = 0;
        String str = "" + result + "";
        for (int j = 0; j < str.length(); j++) {
            sum += str.charAt(j) - '0';
        }
        if ((result + sum) == n) {
            System.out.println(result);
            System.out.println("result : "+result+" + sum : "+sum+" = "+n+"");
        } else {
            f(n, (result + 1));
        }
        //해당문제는 재귀함수로풀게되면 스택오버플로우가 발생한다
    }
}
