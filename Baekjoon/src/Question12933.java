import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int qCount = 0;

        for (int i = 0; i < str.length();i++) if (str.charAt(i) == 'q') qCount += 1;
        char[] arr = {'q', 'u', 'a', 'c', 'k'};
        boolean[] strCheck = new boolean[str.length()];
        int result = 1;
        int count = 0;

        if ((str.length() % 5) != 0) { //울음소리는 5의배수이기때문에 5의배수가안나오면 중간에끊긴울음이므로 성립안됨
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < qCount;i++) {
            for (int j = 0; j < str.length();j++) {
                if (count == 5) count = 0;
                if (!strCheck[j] && str.charAt(j) == arr[count]) {
                    count += 1;
                    strCheck[j] = true;
                }
            }
            for (int j = 0; j < str.length();j++) {
                if (!strCheck[j]) {
                    result += 1;
                    break;
                }
            }
            if ((count % 5) != 0) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0 ;i < str.length();i++) {
            if (!strCheck[i])  {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(result);
    }
}
