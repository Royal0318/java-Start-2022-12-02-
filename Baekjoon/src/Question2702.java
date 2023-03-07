import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int start = 1;
            int small = 0;
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (true) {
                if ((a % start) == 0 && (b % start) == 0) {

                    max = start;
                }
                if ((start % a) == 0 && (start % b) == 0) {
                    small = start;
                    break;
                }
                start++;
            }
            System.out.println(""+small+" "+max+"");
        }
    }
}
