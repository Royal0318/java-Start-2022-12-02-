import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char temp = str.charAt(0);

        boolean check = false;

        for (int i = 1; i < str.length(); i++) {
            if (temp != str.charAt(i)) {
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(-1);
            return;
        }

        boolean resultCheck = false;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                resultCheck = true;
                break;
            }
        }
        if (resultCheck) {
            System.out.println(str.length());
        }
        else {
            System.out.println(str.length() - 1);
        }
    }
}
