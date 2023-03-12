import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100];
        int arrCount = 0;
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = m; j <= n; j++) {
                if ((Math.pow(i, 2)) == j) {
                    arr[arrCount] += j;
                    arrCount += 1;
                }
            }
        }
        /*
        Math.pow함수를 사용하여 i의 제곱값이 j와 일치할경우 해당 arr인덱스에 값을 저장한다
         */
        Arrays.sort(arr);
        //낮은것부터 높은것까지 정렬한다
        for (int i = 0; i < 100; i++) {
            sum += arr[i];
        }
        if (arrCount >= 1) {
            System.out.println("" + sum + "\n" + arr[arr.length - arrCount] + "");
        } else {
            System.out.println(-1);
        }
        //출력시 전체 arr 끝에서 arrCount만큼 뺀 값이 제일작은값이므로 해당값을 출력 제곱근이없는경우 -1출력
    }
}
