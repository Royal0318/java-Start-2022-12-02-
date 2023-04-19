import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];
        //2차원배열 구간합이기때문에 미리 한줄 더늘린다
        for (int i = 1; i <= N;i++) {
            st = new StringTokenizer(br.readLine());//입력하기전 초기화
            for (int j = 1; j <= N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //미리 배열입력
            }
        }

        for (int i = 1; i <= N;i++) {
            for (int j = 1; j <= N;j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + arr[i][j];
            }
            //구간합공식에의해 다시 덮어씌움
        }
        for (int i = 0; i < TC;i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int four = Integer.parseInt(st.nextToken());

            int result = arr[three][four] - arr[one - 1][four] - arr[three][two - 1] + arr[one - 1][two - 1];
            //위 입력에 따른 값을 얻기위한공식
            System.out.println(result);
        }
    }
}