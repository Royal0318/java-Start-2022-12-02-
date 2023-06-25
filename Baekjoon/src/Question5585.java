import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {500,100,50,10,5,1};

        int money = (1000 - Integer.parseInt(br.readLine()));

        int result = 0;
        for (int i = 0; i < arr.length;i++) {
            result += (money / arr[i]);

            money -= (money / arr[i] * arr[i]);
        }
        System.out.println(result);
    }
}
