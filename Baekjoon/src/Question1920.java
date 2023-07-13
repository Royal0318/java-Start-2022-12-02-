import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M;i++) {
            boolean check = false;
            int mNum = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = (arr.length - 1);

            while (start <= end) {
                int middle = ((start + end) / 2);

                if (arr[middle] == mNum) { //판단 시작
                    check = true;
                    sb.append(1).append("\n");
                    break;
                } else if (arr[middle] < mNum) { //만약 찾는숫자가 더큰경우
                    start = (middle + 1); //스타트지점을 중간지점 + 1위치로 이동
                    //+ 1인이유는 중간의 값과 비교했어도 num값이 더 크기때문
                } else { //반대인경우에는 끝지점을 중간지점 - 1 로 대폭 이동
                    end = (middle - 1);
                }
            }
            if (!check) {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
