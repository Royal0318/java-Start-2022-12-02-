import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for (int i = 0; i <= n;i++) {
            if (i == 0) {
                arr[0] = 0;
            } else if (i == 1) {
                arr[1] = 1;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]);
            }
        }
        System.out.println(""+arr[n]+"");
        //따로 변수를 만들어서 arr[i]값을 담게되면 틀렸다고 나옴 주의!
    }
}
