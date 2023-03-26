import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 2) {
            int one = Integer.parseInt(br.readLine());
            int two = Integer.parseInt(br.readLine());

            for (int i = 1 ; i <= Math.min(one, two) ; i ++) {
                if ((one % i) == 0 && (two % i) == 0) {
                    System.out.println(i);
                }
            }
        } else {
            int one = Integer.parseInt(br.readLine());
            int two = Integer.parseInt(br.readLine());
            int three = Integer.parseInt(br.readLine());

            for (int i = 1; i <= Math.min(one,Math.min(two, three)) ; i ++) {
                if ((one % i) == 0 && (two % i) == 0 && (three % i) == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
