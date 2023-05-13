import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length();i++) {
            arr[i] = str.charAt(i) - '0';
        }
        for (int i = 0; i < str.length() - 1;i++) {
            for (int j = 0; j < str.length() - 1;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = str.length() - 1; i >= 0;i--) { //다른 정렬 코드는같지만 거꾸로 출력하기때문에 거꾸로 붙임
           sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
