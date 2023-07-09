import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "666";
        int result = 0;
        while (N > 0) {
            if (Integer.toString(result).contains(str)) {
                N -= 1;
            }
            result += 1;
        }
        System.out.println(result-1);
    }
}
