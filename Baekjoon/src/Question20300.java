import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question20300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] arr = new long[N];
        long result = 0; //정답

        st = new StringTokenizer(br.readLine()); //근손실 정도 저장
        for (int i = 0 ; i < N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr); //오름차순 정렬

        if ((N % 2) == 0) { //짝수인경우
            for (int i = 0 ; i < (arr.length / 2);i++) {
                result = Math.max(result, (arr[i] + arr[N - 1 - i]));
                //M값을 정하기위해서 제일 작은값과 제일큰값이 더해져야 나머지들은 M보다 작아지기 때문이다
            }
        }
        else { //홀수인경우
            for (int i = 0 ; i < ((arr.length - 1) / 2);i++) { //홀수는 제일큰값 계산X
                result = Math.max(result,(arr[i] + arr[N - 2 - i]));
                //끝에것을 계산하지않는다 이유는 마지막날에는 기구를 1개만 사용하기 때문이다
            }
        }
        System.out.println(result);
    }
}
