import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int result = 0;
        int[] arr = new int[testCase];

        for (int i = 0; i < testCase;i++) {
            arr[i] = Integer.parseInt(br.readLine()); //레벨에따른 잘못된 점수입력
        }
        for (int i = (testCase - 2);i >= 0;i--) { //마지막인덱스의 전인덱스를 다음것과 비교해서 큰경우에 둘이의 차를 저장하고 i의 인덱스를 다음비교를위해 i + 1 - 1의 값으로 덮어씌운다
            if (arr[i] >= arr[i + 1]) {
                result += (arr[i] - arr[i + 1] + 1);
                arr[i] = (arr[i + 1] - 1);
            }
        }
        System.out.println(result);
    }
}
