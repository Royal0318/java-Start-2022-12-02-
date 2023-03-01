import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num + 1];
        //문제의 내용은 0번째가 0이고 1번째가 1이기 때문에 예외처리가 필요하다
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
                arr[0] = 0;
             else if (i == 1) {
                arr[1] = 1;
            } else {
                arr[i] = (arr[i - 1] + arr[i - 2]);
            }
        }
        System.out.println("" + arr[num] + "");
    }
}
