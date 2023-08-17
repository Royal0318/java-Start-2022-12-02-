import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question25918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int min = Integer.MIN_VALUE;
        int result = 0;

        for (int i = 0 ; i < str.length();i++) {
            if (str.charAt(i) == '(') { //열린괄호라면 변수 추가 1
                result += 1;
            }
            else { //닫힌괄호라면 변수 감소 1
                result -= 1;
            }
            if (Math.abs(result) > min) { //절대값치를 min변수와 비교하여 큰경우 교체
                min = Math.abs(result);
            }
        }
        if (result == 0) { //모두 pop된경우 result가 0
            System.out.println(min);
        }
        else { //남아있는경우는 성립되지않는경우
            System.out.println(-1);
        }
    }
}
