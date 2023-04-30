import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
