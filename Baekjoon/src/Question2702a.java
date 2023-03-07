import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2702a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*2];
        int[] cal = new int[n*2];
        int small = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (((i + 1) % 2) == 0) {
                if (arr[i] < arr[i - 1]) {
                    small = arr[i];
                } else if (arr[i] > arr[i - 1]) {
                    small = arr[i-1];
                } else {
                    cal[i] = arr[i];
                }
                for (int j = 1; j <= small ; j++) {
                    if ((arr[i - 1] % j) == 0 && (arr[i] % j) == 0) {
                        cal[i] = j;
                        cal[i-1] = ((arr[i-1] * arr[i])/cal[i]);
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(""+cal[i]+"");
        }
    }
}
