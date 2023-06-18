import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question11656a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        String str = br.readLine();

        for (int i = 0; i < str.length();i++) {
           result.add(str.substring(i));
        }
        Collections.sort(result);
        for (String s : result) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
