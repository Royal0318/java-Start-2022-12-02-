import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        boolean check = false;
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == 'S') {
                result += 1;
            } else if (str.charAt(i) == 'L') {
                i += 1;
                result += 1;
                check = true;
            }
        }
        if (check)  System.out.println(result + 1);
        else  System.out.println(result);
    }
}
