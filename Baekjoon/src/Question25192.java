import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Question25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        HashSet<String> hash = new HashSet<>();
        int count = 0;
        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                if (!hash.isEmpty()) {
                    hash.clear();
                }
            }
            else {
                if (!hash.contains(str)) {
                    hash.add(str);
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
