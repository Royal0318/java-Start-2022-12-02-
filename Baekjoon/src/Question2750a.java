import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2750a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];

        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N - 1;i++) {
            for (int j = 0; j < N - 1 - i;j++) {
                if (arr[j] > arr[j + 1]) { //swap
                    int temp = arr[j]; //스왑하기전 미리 값을 저장한다
                    arr[j] = arr[j + 1]; //다음것을 앞에있는 배열에 저장
                    arr[j + 1] = temp; //다음 배열에있는 값에 temp를 할당하여 스왑완료
                }
            }
        }
        for (int i = 0; i < N;i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
